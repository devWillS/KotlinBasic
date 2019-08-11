package kotlins.basic.q25.views.list

import kotlins.basic.q25.common.mvc.BaseModel
import kotlins.basic.q25.common.mvc.BasePresenter
import kotlins.basic.q25.common.mvc.BaseView
import kotlins.basic.q25.models.entity.Todo

interface TodoListContracts {
    interface Model : BaseModel<Presenter> {
        fun getAllTodo(): List<Todo>
        fun deleteTodo(todoId: Int)
    }

    interface View : BaseView<Presenter> {
        fun setupView(todoList: List<Todo>)
        fun notifyDataSetChanged()
    }

    interface Presenter : BasePresenter {
        fun registerTodoButtonClicked()
        fun todoSelected(position: Int)
        fun deletePosition(position: Int)
    }
}