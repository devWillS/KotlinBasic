package kotlins.basic.q23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intent = intent
        val text = intent.getStringExtra(TEXT_STR)
        textView.text = text
    }

    companion object {
        const val TEXT_STR = "textStr"
    }
}