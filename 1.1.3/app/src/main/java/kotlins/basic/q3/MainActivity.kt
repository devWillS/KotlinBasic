package kotlins.basic.q3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num = 1

        printIf(num)
        num = 2
        printIfElse(num)
        printIfElseIf(num)

        printWhile()
        printDoWhile()
        printFor()
        printForEx()

        printWhen(num)
    }

    // if
    private fun printIf(num: Int) {
        println("if")
        if (num == 1) {
            println(num)
        }
    }

    // if else
    private fun printIfElse(num: Int) {
        println("if else")
        if (num == 1) {
            print("ここには来ない")
        } else {
            println(num)
        }
    }

    // if else if
    private fun printIfElseIf(num: Int) {
        println("if else if")
        if (num == 1) {
            print("ここには来ない")
        } else if (num == 2) {
            println(num)
        }
    }

    // while
    private fun printWhile() {
        println("while")
        var cnt = 1
        while (true) {
            println(cnt++)
            if (cnt > 10) {
                break
            }
        }
    }

    // do while
    private fun printDoWhile() {
        println("do while")
        var cnt = 0
        do {
            println(++cnt)
        } while (cnt < 10)
    }

    // for
    private fun printFor() {
        println("for")
        for (i in 1..10) {
            println(i)
        }
    }

    // 高速列挙構文
    private fun printForEx() {
        println("高速列挙構文")
        val list = arrayListOf("one", "two", "three")
        for (str in list) {
            println(str)
        }
    }

    //when
    private fun printWhen(num: Int) {
        println("when")
        when (num) {
            2 ->
                println(num)
            else ->
                print("ここには来ない")
        }
    }
}