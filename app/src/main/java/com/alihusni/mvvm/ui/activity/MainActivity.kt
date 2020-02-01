package com.alihusni.mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alihusni.mvvm.R
import com.alihusni.mvvm.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter =
            TabAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }
}
