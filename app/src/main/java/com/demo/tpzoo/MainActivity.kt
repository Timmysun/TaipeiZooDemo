package com.demo.tpzoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.tpzoo.ui.CategoryListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CategoryListFragment.newInstance())
                .commitNow()
        }
    }
}