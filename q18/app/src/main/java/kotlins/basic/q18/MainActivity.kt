package kotlins.basic.q18

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var list: MutableList<RowData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        list = ArrayList()
        list.add(RowData(resources.getDrawable(R.drawable.icon_black, theme), "aaaaa\nbbbbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_blue, theme), "aaaaa\nbbbsbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_blue_green, theme), "aaadaa\nbbbbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_brown, theme), "aaaaa\nbbbfbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_gray, theme), "aaaaa\nbbbebb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_green, theme), "aasaaa\nbbbbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_light_green, theme), "aaaaa\nbbcbbb"))
        list.add(RowData(resources.getDrawable(R.drawable.icon_pink, theme), "aawaaa\nbbbbb"))


        val adapter = TestRecycleViewAdapter(list)

        val llm = LinearLayoutManager(this)

        testRecyclerView.addItemDecoration(DividerItemDecoration(this))

        testRecyclerView.setHasFixedSize(true)

        testRecyclerView.layoutManager = llm

        testRecyclerView.adapter = adapter
    }
}
