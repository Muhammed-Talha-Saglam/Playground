package com.tokeninc.playground.tablayoutContent

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment, private val tabCount: Int): FragmentStateAdapter(fragment) {
    override fun getItemCount() = tabCount

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TabFragmentOne()
            1 -> TabFragmentTwo()
            else -> TabFragmentThree()
        }
    }

}