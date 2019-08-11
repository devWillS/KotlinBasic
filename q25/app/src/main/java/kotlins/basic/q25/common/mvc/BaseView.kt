package kotlins.basic.q25.common.mvc

interface BaseView<T> {
    fun setPresenter(presenter: T)
}