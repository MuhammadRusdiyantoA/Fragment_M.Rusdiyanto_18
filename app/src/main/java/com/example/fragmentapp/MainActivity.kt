package com.example.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentapp.fragment.DashboardFragment
import com.example.fragmentapp.fragment.HomeFragment
import com.example.fragmentapp.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val dashboardFragment = DashboardFragment()
        val settingsFragment = SettingsFragment()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav)

        //membuat fragment home menjadi default
        makeCurrentFragment(homeFragment)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.default_home -> makeCurrentFragment(homeFragment)
                R.id.dashboard -> makeCurrentFragment(dashboardFragment)
                R.id.settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}