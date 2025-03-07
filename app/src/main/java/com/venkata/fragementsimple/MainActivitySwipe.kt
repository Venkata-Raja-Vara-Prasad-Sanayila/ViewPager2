package com.venkata.fragementsimple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.venkata.fragementsimple.databinding.ActivityMainSwipeBinding

class MainActivitySwipe : AppCompatActivity() {
    lateinit var binding: ActivityMainSwipeBinding
    private lateinit var viewpagerAdapter: ViewpagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSwipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfFragments = listOf(HomeFragment(), ProfileFragment(), SettingsFragment())


        viewpagerAdapter = ViewpagerAdapter(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = viewpagerAdapter


        // Attach dots (TabLayout) with ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        // Handle swipe dots update
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDots(position)
            }
        })
    }

    private fun updateDots(selectedPosition: Int) {
        for (i in 0 until binding.tabLayout.tabCount) {
            val tab = binding.tabLayout.getTabAt(i)
            tab?.setIcon(if (i == selectedPosition) R.drawable.ic_dot_selected else R.drawable.ic_dor_unselected)
        }
    }
}