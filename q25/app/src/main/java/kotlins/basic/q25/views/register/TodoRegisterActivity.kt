package kotlins.basic.q25.views.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlins.basic.q25.R
import kotlins.basic.q25.common.EditStatus
import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil
import kotlinx.android.synthetic.main.activity_todo_register.*

class TodoRegisterActivity : AppCompatActivity(), TodoRegisterContracts.Presenter {
    private val model: TodoRegisterContracts.Model = TodoRegisterModel()
    private lateinit var view: TodoRegisterContracts.View
    lateinit var editStatus: EditStatus
    lateinit var todo: Todo



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_register)

        editStatus = intent.extras?.get("editStatus") as EditStatus


    }

    override fun onStart() {
        super.onStart()
        view = todoRegisterFragment as TodoRegisterFragment
        setupView()
    }

    private fun setupView() {
        model.setPresenter(this)
        view.setPresenter(this)

        when (editStatus) {
            EditStatus.NEW ->
                view.setupView(null)
            EditStatus.EDIT -> {
                todo = TodoUtil.getTodo(intent.getIntExtra("todo", 1))
                view.setupView(todo)
            }
        }
    }

    override fun registerClicked(title: String, content: String) {
        if (title.isEmpty()) {
            view.titleEditTextError()
            return
        }

        if (content.isEmpty()) {
            view.contentEditTextError()
            return
        }

        when (editStatus) {
            EditStatus.NEW -> {
                model.add(title, content)
                finish()
            }

            EditStatus.EDIT -> {
                model.update(todo, title, content)
                finish()
            }
        }
    }
}
