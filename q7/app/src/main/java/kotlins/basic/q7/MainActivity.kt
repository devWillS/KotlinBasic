package kotlins.basic.q7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Result {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val math = Math(this)
        math.calculate(2, 3)
    }

    override fun result(resultValue: Int) {
        println(resultValue)
    }
}
