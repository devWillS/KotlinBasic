package kotlins.basic.q31.api

import junit.framework.TestCase.assertEquals
import kotlins.basic.q31.models.entities.Weather
import kotlins.basic.q31.views.MainContracts
import kotlins.basic.q31.views.MainModel
import org.junit.After
import org.junit.Before
import org.junit.Test

class WeatherApiTest : MainContracts.Presenter {
    override fun getItems(): Array<CharSequence>? {
        return arrayOf("")
    }

    override fun forecastSelected(position: Int) {

    }

    override fun receivedForecasts(weather: Weather) {
        assertEquals(weather.location?.city, "東京")
        assertEquals(weather.forecasts?.get(0)?.dateLabel, "今日")
    }

    override fun receivedError() {

    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    fun getWeather() {
        val model = MainModel()
        model.setPresenter(this)
        model.getForecasts()
    }
}