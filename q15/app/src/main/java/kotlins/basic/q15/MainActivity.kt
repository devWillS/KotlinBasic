package kotlins.basic.q15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AlertDialogUtil.DialogUtilListener {
    override fun onPositive() {
        println("Dialog: Clicked OK")
    }

    override fun onNegative() {
        println("Dialog: Clicked Cancel")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        button.setOnClickListener {
            AlertDialogUtil.createOneButtonDialog(this, R.string.dialog_title, R.string.dialog_message, this)
        }
    }
}
