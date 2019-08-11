package kotlins.basic.q25.views.register

import kotlins.basic.q25.models.entity.Todo
import kotlins.basic.q25.utils.TodoUtil


class TodoRegisterModel : TodoRegisterContracts.Model {

    private lateinit var presenter: TodoRegisterContracts.Presenter

    override fun setPresenter(presenter: TodoRegisterContracts.Presenter) {
        this.presenter = presenter
    }

    override fun add(title: String, content: String) {
        TodoUtil.add(title, content)
    }

    override fun update(todo: Todo, title: String, content: String) {
        TodoUtil.update(todo, title, content)
    }
}