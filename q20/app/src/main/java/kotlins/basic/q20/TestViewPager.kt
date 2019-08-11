package kotlins.basic.q20

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class TestViewPager(fm: FragmentManager, var pageList: List<Page>) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return pageList.size
    }

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment
        fragment = PageFragment.newInstance(pageList, position)
        return fragment
    }
}