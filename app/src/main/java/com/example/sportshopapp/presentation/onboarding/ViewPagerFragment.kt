package com.example.sportshopapp.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sportshopapp.R
import com.example.sportshopapp.presentation.onboarding.screens.FirstScreen
import com.example.sportshopapp.presentation.onboarding.screens.LoginOrSigninScreen
import com.example.sportshopapp.presentation.onboarding.screens.SecondScreen
import com.example.sportshopapp.presentation.onboarding.screens.ThirdScreen


class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen(),
            LoginOrSigninScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
        return view
    }


}