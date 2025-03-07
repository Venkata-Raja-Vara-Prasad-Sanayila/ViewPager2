package com.venkata.fragementsimple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.venkata.fragementsimple.databinding.ActivityCustomTabBinding
import com.venkata.fragementsimple.databinding.CustomTabBinding
import com.venkata.fragementsimple.databinding.CustomTabDownBinding

class CustomTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomTabBinding
    private lateinit var viewpagerAdapter: ViewpagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomTabBinding.inflate(layoutInflater)
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
            val customTabBinding = CustomTabBinding.inflate(layoutInflater)

            when (position) {
                0 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.ic_home)
                }
                1 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.ic_profile)
                    customTabBinding.tabText.text = "Profile"
                }
                2 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.baseline_settings_24)
                    customTabBinding.tabText.text = "Settings"
                }
            }

            tab.customView = customTabBinding.root
        }.attach()


    }
}