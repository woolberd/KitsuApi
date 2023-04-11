package com.example.kitsuapi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitsuapi.databinding.ActivityMainBinding
import com.example.kitsuapi.ui.adapter.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Manga"
                }
                1 -> {
                    tab.text = "Anime"
                }
            }
        }.attach()
    }
}