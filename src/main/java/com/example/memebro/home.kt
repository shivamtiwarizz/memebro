package com.example.memebro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    // Inside your activity or fragment
    lateinit var tabLayout: TabLayout // Reference to your TabLayout
    lateinit var viewPager: ViewPager // Reference to your ViewPager

// In your onCreate() method or wherever you initialize your tabLayout and viewPager variables
    tabLayout = findViewById(R.id.tab_layout)
//    viewPager = findViewById(R.id.view_pager)


    // Create an adapter to handle the tabs and their content
//    val adapter = TabPagerAdapter(supportFragmentManager)
//    adapter.addFragment(ChatsFragment(), "Chats")
//    adapter.addFragment(StatusFragment(), "Status")
//    adapter.addFragment(CallsFragment(), "Calls")
//    viewPager.adapter = adapter
//
//// Set the adapter to the ViewPager and the ViewPager to the TabLayout
//    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//        tab.text = adapter.getPageTitle(position)
//    }.attach()

//    override fun onBackPressed() {
//        moveTaskToBack(true)
//    }
}}