package com.loguito.clase8.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.loguito.clase8.views.fragments.AddPersonFragment
import com.loguito.clase8.views.fragments.PersonListFragment
import com.loguito.clase8.views.fragments.ProductListFragment

class MainPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonListFragment()
            1 -> ProductListFragment()
            else -> AddPersonFragment()
        }
    }
}