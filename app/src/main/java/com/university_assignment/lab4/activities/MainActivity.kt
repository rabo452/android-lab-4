package com.university_assignment.lab4.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.university_assignment.lab4.R
import com.university_assignment.lab4.fragments.ImageFragment
import com.university_assignment.lab4.fragments.Task1Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            replaceFragment(ImageFragment.newInstance(R.drawable.img1))
        }

        val bottomNavMenu = findViewById<BottomNavigationView>(R.id.nav_menu)
        bottomNavMenu.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.img_1 -> {
                    replaceFragment(ImageFragment.newInstance(R.drawable.img1))
                    true
                }
                R.id.img_2 -> {
                    replaceFragment(ImageFragment.newInstance(R.drawable.img2))
                    true
                }
                R.id.img_3 -> {
                    replaceFragment(ImageFragment.newInstance(R.drawable.img3))
                    true
                }
                R.id.task_1 -> {
                    replaceFragment(Task1Fragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}