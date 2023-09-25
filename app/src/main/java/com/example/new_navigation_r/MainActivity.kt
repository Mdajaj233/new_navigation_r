package com.example.new_navigation_r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ToolbarWidgetWrapper
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawer = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer)
        val navigationView = findViewById<NavigationView>(R.id.navigationview)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        changefragment(HomeFragment())
        navigationView.setNavigationItemSelectedListener { item1 ->

            when (item1.itemId) {
                R.id.home -> changefragment(HomeFragment())
                R.id.plush -> changefragment(PlushFragment())
                R.id.folder -> changefragment(FolderFragment())

            }
            drawer.close()
            true


        }
        toolbar.setNavigationOnClickListener {
            drawer.open()
        }

        bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> changefragment(HomeFragment())
                R.id.plush -> changefragment(PlushFragment())
                R.id.folder -> changefragment(FolderFragment())
                R.id.setting->changefragment(AettingFragmnet())

            }
            true
        }

    }


    fun changefragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }

}


