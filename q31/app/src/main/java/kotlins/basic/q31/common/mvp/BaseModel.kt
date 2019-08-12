package kotlins.basic.q31.common.mvp

interface BaseModel<T> {
    fun setPresenter(presenter: T)
}