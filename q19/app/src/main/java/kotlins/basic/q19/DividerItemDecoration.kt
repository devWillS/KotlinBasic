package kotlins.basic.q19

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

internal class DividerItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = this.space
        outRect.right = this.space

        //for vertical scrolling
        outRect.bottom = this.space
        outRect.top = this.space
    }
}