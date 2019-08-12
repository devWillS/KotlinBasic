package kotlins.basic.q31.views

import kotlins.basic.q31.common.mvp.BaseModel
import kotlins.basic.q31.common.mvp.BasePresenter
import kotlins.basic.q31.common.mvp.BaseView
import kotlins.basic.q31.models.entities.Forecast
import kotlins.basic.q31.models.entities.Weather

interface MainContracts {
    interface Model : BaseModel<Presenter> {
        fun getForecasts()
    }

    interface View : BaseView<Presenter> {
        fun setupView(forecastList: List<Forecast>)
        fun reloadForecastListData()
        fun setDescriptionText(text: String)
    }

    interface Presenter : BasePresenter {
        fun receivedForecasts(weather: Weather)
        fun receivedError()
        fun getItems(): Array<CharSequence>?
        fun forecastSelected(position: Int)
    }
}