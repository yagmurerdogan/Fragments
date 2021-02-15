package com.yagmurerdogan.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslsikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentListesi.add(FragmentBirinci())
        fragmentListesi.add(FragmentIkinci())
        fragmentListesi.add(FragmentUcuncu())

        val adapter = MyViewPagerAdapter(this)
        viewpager2.adapter = adapter

        fragmentBaslsikListesi.add("Bir")
        fragmentBaslsikListesi.add("İki")
        fragmentBaslsikListesi.add("Üç")

        TabLayoutMediator(tablayout,viewpager2) { tab, position ->
            tab.setText(fragmentBaslsikListesi[position])
        }.attach()

        tablayout.getTabAt(0)!!.setIcon(R.drawable.resim)
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentListesi.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]
        }

    }
}