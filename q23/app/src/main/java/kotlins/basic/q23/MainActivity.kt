package kotlins.basic.q23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(application, SubActivity::class.java)
            intent.putExtra(SubActivity.TEXT_STR, editText.text.toString())
            startActivity(intent)
        }
    }
}
