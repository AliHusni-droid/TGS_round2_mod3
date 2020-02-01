package com.alihusni.mvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alihusni.mvvm.ui.fragment.MovieFragment

class TabAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }
    private val pages = listOf(
        MovieFragment(),
        Fragment()
    )
    override fun getCount(): Int{
        return pages.size
    }
    fun getPagesTitle(position: Int): CharSequence?{
        return when (position){
            0 -> "Movie"
            1 -> "TV"
            else -> "NO DATA"
        }
    }
}