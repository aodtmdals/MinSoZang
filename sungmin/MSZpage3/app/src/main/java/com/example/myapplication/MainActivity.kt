package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_navi = findViewById<ImageView>(R.id.btn_navi)
        btn_navi.setOnClickListener {
            val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
            layout_drawer.openDrawer(GravityCompat.END)
        }

        val naviView = findViewById<NavigationView>(R.id.naviView)
        naviView.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.breastmilk_information->startActivity(Intent(this,MainActivity::class.java))
            R.id.breastmilk_share->startActivity(Intent(this,SubActibity::class.java))
        }
        layout_drawer.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.END))
        {
            layout_drawer.closeDrawers()
        }
        else
        {
            super.onBackPressed()
        }
    }
}