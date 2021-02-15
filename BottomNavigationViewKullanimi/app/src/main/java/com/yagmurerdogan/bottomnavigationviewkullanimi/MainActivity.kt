package com.yagmurerdogan.bottomnavigationviewkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tempFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_tutucu,FragmentBirinci()).commit()

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem->
            if (menuItem.itemId == R.id.action_bir) {
                Toast.makeText(applicationContext,"Bir tıklandı",Toast.LENGTH_SHORT).show()

                tempFragment = FragmentBirinci()
            }
            if (menuItem.itemId == R.id.action_iki) {
                Toast.makeText(applicationContext,"İki tıklandı",Toast.LENGTH_SHORT).show()

                tempFragment = FragmentIkinci()
            }
            if (menuItem.itemId == R.id.action_uc) {
                Toast.makeText(applicationContext,"Üç tıklandı",Toast.LENGTH_SHORT).show()

                tempFragment = FragmentUcuncu()
            }
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_tutucu,tempFragment).commit()

            true

        }
    }
}