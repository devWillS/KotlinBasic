package kotlins.basic.q21

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        val iconList = ArrayList<Drawable>()

        iconList.add(resources.getDrawable(R.drawable.apple, theme))
        iconList.add(resources.getDrawable(R.drawable.android, theme))

        val adapter = TabLayoutFragmentPagerAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = iconList.size
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)

        for (i in iconList.indices) {
            val tab = tabLayout.getTabAt(i)
            tab?.icon = iconList[i]
        }
    }
}
