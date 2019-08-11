package kotlins.basic.q20

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
        val pageList = ArrayList<Page>()
        pageList.add(Page("aaa"))
        pageList.add(Page("bbb"))
        pageList.add(Page("ccc"))

        val adapter = TestViewPager(supportFragmentManager, pageList)
        pager.adapter = adapter
    }
}
