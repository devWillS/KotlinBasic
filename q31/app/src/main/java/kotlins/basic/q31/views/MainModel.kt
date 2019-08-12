package kotlins.basic.q31.views

import android.content.Context
import androidx.room.Room
import kotlins.basic.q31.models.api.APIService
import kotlins.basic.q31.models.api.WeatherHacksInterface
import kotlins.basic.q31.models.db.ResponseData
import kotlins.basic.q31.models.db.WeatherDatabase
import kotlins.basic.q31.models.entities.Description
import kotlins.basic.q31.models.entities.Forecast
import kotlins.basic.q31.models.entities.Weather
import kotlins.basic.q31.util.objectOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel : MainContracts.Model {

    private lateinit var presenter: MainContracts.Presenter

    private lateinit var weatherDatabase: WeatherDatabase

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

    override fun setupRoom(context: Context) {
        weatherDatabase = Room.databaseBuilder(context, objectOf<WeatherDatabase>(), "weather.db").allowMainThreadQueries().build()
    }

    override fun saveData(description: Description, forecastList: List<Forecast>) {
        val descriptionDao = weatherDatabase.descriptionDao()
        descriptionDao.deleteALL()
        descriptionDao.insertEntity(description)

        val forecastDao = weatherDatabase.forecastDao()
        forecastDao.deleteALL()
        forecastDao.insertEntities(forecastList)
    }

    override fun getData(): ResponseData {

        val descriptionDao = weatherDatabase.descriptionDao()
        val description = descriptionDao.getNewest()

        val forecastDao = weatherDatabase.forecastDao()
        val forecastList = forecastDao.getList()

        return ResponseData(description,forecastList)
    }
}