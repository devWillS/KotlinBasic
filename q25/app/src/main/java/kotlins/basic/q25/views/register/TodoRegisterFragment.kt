package kotlins.basic.q25.views.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlins.basic.q25.R
import kotlins.basic.q25.models.entity.Todo
import kotlinx.android.synthetic.main.fragment_todo_register.*


/**
 * A simple [Fragment] subclass.
 *
 */
class TodoRegisterFragment : Fragment(), TodoRegisterContracts.View {

    private lateinit var presenter: TodoRegisterContracts.Presenter

    override fun setPresenter(presenter: TodoRegisterContracts.Presenter) {
        this.presenter = presenter
    }

    override fun titleEditTextError() {
        titleEditText.error = "Please enter title"
    }

    override fun contentEditTextError() {
        contentEditText.error = "Please enter content"
    }

    override fun setupView(todo: Todo?) {
        if (todo == null) {
            toolbar.title = "新規ToDo"
        } else {
            toolbar.title = todo.title
            titleEditText.setText(todo.title)
            contentEditText.setText(todo.contents)
        }

        registerButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            presenter.registerClicked(title, content)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_register, container, false)
    }


}
