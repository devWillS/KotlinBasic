package kotlins.basic.q31.models.api

import kotlins.basic.q31.models.entities.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherHacksInterface  {
    @GET("v1")
    fun webservice(@Query("city") city: String): Call<Weather>
}