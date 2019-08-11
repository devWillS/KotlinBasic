package kotlins.basic.q25.utils

import java.util.*

object DateUtil {
    fun getDaysAfter(daysAfter: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, daysAfter)

        return calendar.time
    }
}