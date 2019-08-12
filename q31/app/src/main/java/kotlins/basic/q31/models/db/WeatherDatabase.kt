package kotlins.basic.q31.models.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlins.basic.q31.models.entities.Description
import kotlins.basic.q31.models.entities.Forecast

@Database(entities = [Description::class, Forecast::class], version = 1, exportSchema = false)
@TypeConverters(ImageTypeConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun descriptionDao(): DescriptionDao
    abstract fun forecastDao(): ForecastDao
}