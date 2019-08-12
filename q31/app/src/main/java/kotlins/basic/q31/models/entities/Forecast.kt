package kotlins.basic.q31.models.entities

class Forecast {
    var dateLabel: String? = null
    var telop: String? = null
    var date: String? = null
    var image: Image? = null

    override fun toString(): String {
        return "Forecast(dateLabel=$dateLabel, telop=$telop, date=$date, image=$image)"
    }


}