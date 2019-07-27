package kotlins.basic.q5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fiveYearTeacher = FiveYearTeacher("山田太郎", 23, true, 200000.0)
        val tenYearTeacher = TenYearTeacher("山田花子", 23, false, 400000.0)

        println(fiveYearTeacher.calculateSalary())
        println(tenYearTeacher.calculateSalary())
    }
}
