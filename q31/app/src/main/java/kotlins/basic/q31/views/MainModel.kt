package kotlins.basic.q31.views

import kotlins.basic.q31.models.api.APIService
import kotlins.basic.q31.models.api.WeatherHacksInterface
import kotlins.basic.q31.models.entities.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel : MainContracts.Model {

    private lateinit var presenter: MainContracts.Presenter

    override fun setPresenter(presenter: MainContracts.Presenter) {
        this.presenter = presenter
    }

    override fun getForecasts() {
        val apiInterface = APIService.createService(WeatherHacksInterface::class.java)
        val call = apiInterface.webservice("130010")
        call.enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val weather = response.body()
                if (weather != null) {
                    presenter.receivedForecasts(weather)
                } else {
                    presenter.receivedError()
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                presenter.receivedError()
            }
        })
    }
}