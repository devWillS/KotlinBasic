package kotlins.basic.q22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainToolbar.setOnClickListener{
            val intent = Intent(applicationContext, SubActivity::class.java)
            startActivity(intent)
        }
    }
}
