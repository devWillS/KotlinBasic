package kotlins.basic.q31.common.mvp

interface BaseView<T> {
    fun setPresenter(presenter: T)
}