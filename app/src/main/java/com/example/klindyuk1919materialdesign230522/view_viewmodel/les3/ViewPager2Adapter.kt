package com.example.klindyuk1919materialdesign230522.view_viewmodel.les3

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.klindyuk1919materialdesign230522.R
import com.example.klindyuk1919materialdesign230522.utils.EARTH
import com.example.klindyuk1919materialdesign230522.utils.MARS
import com.example.klindyuk1919materialdesign230522.utils.SOLAR_SYSTEM
import com.example.klindyuk1919materialdesign230522.view_viewmodel.EarthFragment

class ViewPager2Adapter(fa: Fragment) :FragmentStateAdapter(fa) {


    private val fragments = arrayOf(
        SystemFragment.newInstance(),
        MarsFragment.newInstance(),
        EarthFragment.newInstance()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            EARTH -> EarthFragment.newInstance()
            SOLAR_SYSTEM -> SystemFragment.newInstance()
            MARS -> MarsFragment.newInstance()
            else -> {
                EarthFragment.newInstance()
            }
        }    }

    /*override fun getItem(position: Int): Fragment {
        return when (position) {
            EARTH -> EarthFragment.newInstance()
            SOLAR_SYSTEM -> SystemFragment.newInstance()
            MARS -> MarsFragment.newInstance()
            else -> {
                EarthFragment.newInstance()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            EARTH -> resources.getString(R.string.earth)
            SOLAR_SYSTEM -> resources.getString(R.string.solar_system)
            MARS -> resources.getString(R.string.mars)
            else -> resources.getString(R.string.earth)
        }
    }*/
}