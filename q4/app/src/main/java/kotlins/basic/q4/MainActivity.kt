package kotlins.basic.q4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val internship = arrayListOf<Account>()

        internship.add(Account("山田太郎",23,"male","Java"))
        internship.add(Account("山田花子",23,"female","Kotlin"))

        for (account in internship) {
            account.printInfo()
        }
    }
}
