package com.yagmurerdogan.navigationdrawerkullanimi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_baslik.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var tempFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Navigation Drawer"
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this,drawer,toolbar,0,0)
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        val baslik = navigationView.inflateHeaderView(R.layout.navigation_baslik)
        baslik.textViewBaslik.text = "Hoşgeldiniz"

        supportFragmentManager.beginTransaction().add(R.id.fragment_tutucu,FragmentBirinci()).commit()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.nav_item_birinci) {
                Toast.makeText(applicationContext,"BİRİNCİ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentBirinci()
            }
            if (menuItem.itemId == R.id.nav_item_ikinci) {
                Toast.makeText(applicationContext,"İKİNCİ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentIkinci()
            }
            if (menuItem.itemId == R.id.nav_item_ucuncu) {
                Toast.makeText(applicationContext,"ÜÇÜNCÜ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentUcuncu()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_tutucu,tempFragment).commit()
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START)

        } else {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }
    }
}