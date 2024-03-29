package kotlins.basic.q16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        button.setOnClickListener {
            val dialogFragment = TestDialogFragment()
            dialogFragment.show(supportFragmentManager, "sns")
        }
    }
}
