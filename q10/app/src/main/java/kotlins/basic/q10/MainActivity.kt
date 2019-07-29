package kotlins.basic.q10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeImage()

        random_image_button.setOnClickListener{
            changeImage()
        }
    }

    private fun changeImage() {
        val number = (0 until ImageUtil.values().size).random()
        val imageUtil = ImageUtil.values()[number]
        image_view.setImageResource(imageUtil.getResource())
    }
}
