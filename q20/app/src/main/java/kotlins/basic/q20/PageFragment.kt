package kotlins.basic.q20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment() {
    var pageList: List<Page>? = null
    var position: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = (pageList!![position].text)
        currentPage.text = pageText()
    }

    private fun pageText(): String {
        return "" + (position + 1) + " / " + pageList!!.size
    }


    companion object {

        fun newInstance(pageList: List<Page>, position: Int): PageFragment {

            val args = Bundle()

            val fragment = PageFragment()
            fragment.arguments = args

            fragment.pageList = pageList
            fragment.position = position
            return fragment
        }
    }
}