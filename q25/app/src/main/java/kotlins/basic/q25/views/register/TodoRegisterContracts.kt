package kotlins.basic.q25.views.register

import kotlins.basic.q25.common.mvc.BaseModel
import kotlins.basic.q25.common.mvc.BasePresenter
import kotlins.basic.q25.common.mvc.BaseView
import kotlins.basic.q25.models.entity.Todo

interface TodoRegisterContracts {
    interface Model : BaseModel<Presenter> {
        fun add(title: String, content: String)
        fun update(todo: Todo, title: String, content: String)
    }

    interface View : BaseView<Presenter> {
        fun setupView(todo: Todo?)
        fun titleEditTextError()
        fun contentEditTextError()
    }

    interface Presenter : BasePresenter {
        fun registerClicked(title: String, content: String)
    }
}