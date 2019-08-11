package kotlins.basic.q17

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val tz = TimeZone.getTimeZone("Asia/Tokyo")
        calendar.timeZone = tz
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            activity,
            activity as MainActivity, hour, minute, true
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {

    }
}