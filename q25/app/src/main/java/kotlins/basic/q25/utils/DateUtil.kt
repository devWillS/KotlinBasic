package kotlins.basic.q25.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    enum class DateFormat(val format: String) {
        HyphenYearToDay("yyyy-MM-dd")
    }

    fun getDaysAfter(daysAfter: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, daysAfter)

        return calendar.time
    }

    fun toString(date: Date, format: DateFormat): String {
        val pattern = format.format
        val df = SimpleDateFormat(pattern, Locale.JAPAN)
        return df.format(date)
    }
}