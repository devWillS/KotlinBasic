package kotlins.basic.q11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   private lateinit var imm: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


        edit_text.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                if (edit_text.text.isEmpty()) {
                    return@OnKeyListener true
                }
            }
            false
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        imm.hideSoftInputFromWindow(mainLayout.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)

        mainLayout.requestFocus()

        return false
    }
}
