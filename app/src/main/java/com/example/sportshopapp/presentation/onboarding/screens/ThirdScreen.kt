package com.example.sportshopapp.presentation.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.sportshopapp.R


class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_third_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.findViewById<Button>(R.id.next3).setOnClickListener{
            viewPager?.currentItem = 3
        }
        return view
    }


}