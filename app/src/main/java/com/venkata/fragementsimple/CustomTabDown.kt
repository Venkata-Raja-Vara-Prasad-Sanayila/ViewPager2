package com.venkata.fragementsimple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.venkata.fragementsimple.databinding.ActivityCustomTabBinding
import com.venkata.fragementsimple.databinding.ActivityCustomTabDownBinding
import com.venkata.fragementsimple.databinding.CustomTabBinding
import com.venkata.fragementsimple.databinding.CustomTabDownBinding

class CustomTabDown : AppCompatActivity() {
    lateinit var binding: ActivityCustomTabDownBinding
    private lateinit var viewpagerAdapter: ViewpagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCustomTabDownBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCustomTabViewPager()

    }

    private fun setUpCustomTabViewPager() {
        val listOfFragments = listOf(HomeFragment(), ProfileFragment(), SettingsFragment())

        viewpagerAdapter = ViewpagerAdapter(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = viewpagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val customTabBinding = CustomTabDownBinding.inflate(layoutInflater)

            when (position) {
                0 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.ic_home)
                }
                1 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.ic_profile)
                }
                2 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.baseline_settings_24)
                }
            }

            tab.customView = customTabBinding.root
        }.attach()


    }
}