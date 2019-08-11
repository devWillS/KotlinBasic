package kotlins.basic.q21

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class TabLayoutFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return tabTitles.size
    }

    private val tabTitles = arrayOf<CharSequence>("Apple", "Android")

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> FirstTabFragment()
            1 -> SecondTabFragment()
            else -> null
        }
    }
}