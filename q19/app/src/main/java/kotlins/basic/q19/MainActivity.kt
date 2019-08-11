package kotlins.basic.q19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        recyclerView.addItemDecoration(DividerItemDecoration(10))

        val iconList = ArrayList<IconModel>()

        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_black, theme), "black"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_blue, theme), "blue"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_blue_green, theme), "blue_green"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_brown, theme), "brown"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_gray, theme), "gray"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_green, theme), "green"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_light_green, theme), "light_green"))
        iconList.add(IconModel(resources.getDrawable(R.drawable.icon_pink, theme), "pink"))

        val adapter = IconListRecyclerViewAdapter(iconList)

        //setting adapter to recycler
        recyclerView.adapter = adapter
    }
}
