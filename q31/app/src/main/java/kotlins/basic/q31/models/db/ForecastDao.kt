package kotlins.basic.q31.models.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlins.basic.q31.models.entities.Forecast

@Dao
interface ForecastDao {
    @Query("SELECT forecast_id,dateLabel,telop,date,image FROM Forecast")
    fun getList(): List<Forecast>

    @Insert
    fun insertEntity(forecastEntity: Forecast)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertEntities(objects: List<Forecast>)

    @Query("DELETE FROM Forecast")
    fun deleteALL()
}