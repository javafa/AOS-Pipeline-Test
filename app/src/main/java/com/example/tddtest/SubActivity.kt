package com.example.tddtest


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_sub.*
import kotlinx.android.synthetic.main.activity_sub.view.*

class SubActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val adapter = FragmentAdapter(this)
        val fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        adapter.fragments.addAll(fragments)
        viewPager.adapter = adapter

        val tabTitles = arrayOf("One", "Two", "Three")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}

class FragmentAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}







