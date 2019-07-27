package kotlins.basic.q6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<Employee>()

        list.add(Designer("designer1", 23, true, "111-1111", 100000.0, 3))
        list.add(Designer("designer2", 24, false, "222-2222", 100000.0, 4))

        list.add(Programmer("programmer1", 26, true, "333-3333", 100000.0, 4, 'A'))
        list.add(Programmer("programmer2", 27, false, "444-4444", 100000.0, 5, 'C'))

        for (employee in list) {
            println(employee.name + " : " + employee.computeYearlyPay())
        }
    }
}
