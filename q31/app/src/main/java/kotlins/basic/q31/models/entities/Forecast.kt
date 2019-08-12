package kotlins.basic.q31.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Forecast {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "forecast_id")
    var id: Long = 0
    var dateLabel: String? = null
    var telop: String? = null
    var date: String? = null
    var image: Image? = null

    override fun toString(): String {
        return "Forecast(dateLabel=$dateLabel, telop=$telop, date=$date, image=$image)"
    }


}