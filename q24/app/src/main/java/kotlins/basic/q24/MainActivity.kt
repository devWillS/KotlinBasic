package kotlins.basic.q24

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var data: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = getSharedPreferences("Data", MODE_PRIVATE)
        val isFirstLaunch = data.getBoolean("isFirstLaunch", true)
        editor = data.edit()

        if (isFirstLaunch) {
            editor.putBoolean("isFirstLaunch", false)
            editor.apply()
        } else {
            setData()
        }

    }

    private fun setData() {
        val d = 1234.567

        editor.putInt("DataInt", 123)
        editor.putLong("DataLong", java.lang.Double.doubleToRawLongBits(d))
        editor.putString("DataString", "sample")
        editor.apply()

        val dataInt = data.getInt("DataInt", 0)
        val dataLong = data.getLong("DataLong", 0)
        val dataString = data.getString("DataString", null)

        println(
            "SharedPreference:\n" +
                    "Int = " + dataInt + " \n" +
                    "Double = " + java.lang.Double.longBitsToDouble(dataLong) + "\n" +
                    "String = " + dataString
        )
    }
}
