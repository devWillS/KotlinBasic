package kotlins.basic.q25.views.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlins.basic.q25.R
import kotlins.basic.q25.common.EditStatus
import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil
import kotlinx.android.synthetic.main.activity_todo_register.*

class TodoRegisterActivity : AppCompatActivity() {
    lateinit var editStatus: EditStatus
    lateinit var todo: Todo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_register)

        editStatus = intent.extras?.get("editStatus") as EditStatus

        setupView()
    }

    private fun setupView() {
        when (editStatus) {
            EditStatus.NEW ->
                toolbar.title = "新規ToDo"
            EditStatus.EDIT -> {
                todo = TodoUtil.getTodo(intent.getIntExtra("todo", 1))
                toolbar.title = todo.title
                titleEditText.setText(todo.title)
                contentEditText.setText(todo.contents)
            }
        }

        registerButton.setOnClickListener {
            val title = titleEditText.text.toString()
            if (title.isEmpty()) {
                titleEditText.error = "Please enter title"
                return@setOnClickListener
            }

            val content = contentEditText.text.toString()
            if (content.isEmpty()) {
                contentEditText.error = "Please enter content"
                return@setOnClickListener
            }

            when (editStatus) {
                EditStatus.NEW -> {
                    TodoUtil.add(title, content)
                    finish()
                }

                EditStatus.EDIT -> {
                    TodoUtil.update(todo, title, content)
                    finish()
                }
            }
        }
    }
}
