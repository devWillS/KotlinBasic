package kotlins.basic.q25.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlins.basic.q25.R
import kotlins.basic.q25.common.EditStatus
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        setupView()
    }

    private fun setupView() {
        registerTodoButton.setOnClickListener {
            val intent = Intent(this, TodoRegisterActivity::class.java)
            intent.putExtra("editStatus", EditStatus.NEW)
            startActivity(intent)
        }
    }
}
