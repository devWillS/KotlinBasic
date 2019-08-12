package kotlins.basic.q31.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlins.basic.q31.R
import kotlins.basic.q31.models.entities.Forecast
import kotlins.basic.q31.models.entities.Weather
import kotlins.basic.q31.util.guard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContracts.Presenter {
    private val model = MainModel()
    private lateinit var view: MainContracts.View

    private lateinit var weather: Weather
    private var forecastList: ArrayList<Forecast> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        view = mainFragment as MainFragment
        view.setPresenter(this)
        view.setupView(forecastList)
        model.setPresenter(this)
        model.setupRoom(this)
        model.getForecasts()
    }

    override fun receivedForecasts(weather: Weather) {
        this.weather = weather


        weather.forecasts?.let {
            forecastList.clear()
            forecastList.addAll(it)
            view.reloadForecastListData()
        }

        weather.description?.text?.let {
            view.setDescriptionText(it)
        }

        model.saveData(weather.description!!,weather.forecasts!!)
    }

    override fun receivedError() {
        println("API: Received Error")
        val resposeData = model.getData()

        forecastList.clear()
        forecastList.addAll(resposeData.forecastList)
        view.reloadForecastListData()

        resposeData.description.text?.let {
            view.setDescriptionText(it)
        }
    }

    override fun getItems(): Array<CharSequence>? {
        val forecasts = guard(weather.forecasts) {
            return null
        }
        val arrayList = arrayListOf<CharSequence>()
        for (forecast in forecasts) {
            val dateLabel = guard(forecast.dateLabel) {
                return null
            }
            arrayList.add(dateLabel)
        }

        return arrayList.toTypedArray()
    }

    override fun forecastSelected(position: Int) {
        val forecasts = guard(weather.forecasts) {
            return
        }
        val forecast = guard(forecasts[position]) {
            return
        }
        println("forecastttt: ${forecast.toString()}")
    }
}
