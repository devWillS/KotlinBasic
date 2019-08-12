package kotlins.basic.q31.models.db

import kotlins.basic.q31.models.entities.Description
import kotlins.basic.q31.models.entities.Forecast

class ResponseData(
    val description: Description,
    val forecastList: List<Forecast>
) {
}