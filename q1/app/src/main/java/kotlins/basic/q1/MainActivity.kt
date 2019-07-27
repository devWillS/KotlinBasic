package kotlins.basic.q1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = "PRINT"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b: Boolean
        var str: String
        var i: Int
        var d: Double

        b = true
        str = "String"
        i = 1
        d = 2.5

        Log.d(tag, b.toString())
        Log.d(tag, str)
        Log.d(tag, i.toString())
        Log.d(tag, d.toString())

        println("$tag: $b")
        println("$tag: $str")
        println("$tag: $i")
        println("$tag: $d")
    }
}
