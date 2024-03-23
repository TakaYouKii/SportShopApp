package com.example.sportshopapp.presentation.onboarding.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.sportshopapp.R
import com.example.sportshopapp.presentation.registration.LogInActivity
import com.example.sportshopapp.presentation.registration.SignInActivity

class LoginOrSigninScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login_or_signin_screen, container, false)
        view.findViewById<Button>(R.id.btn_sign_in).setOnClickListener{
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
            onBoardingFinished()
        }

        view.findViewById<Button>(R.id.btn_log_in).setOnClickListener{
            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)
            onBoardingFinished()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}