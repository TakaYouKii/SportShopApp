package com.example.sportshopapp.presentation.splashscreen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.sportshopapp.R
import com.example.sportshopapp.presentation.main.MainActivity
import com.example.sportshopapp.presentation.onboarding.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        // Найдем ваш корневой Layout (вместо R.id.main используйте id вашего корневого Layout)
        val rootLayout = findViewById<View>(android.R.id.content)

        // Установим слушатель для обработки изменений insets
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Установим отступы для вашего корневого Layout с учетом системных баров
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Вернем объект WindowInsetsCompat, обновленный insets
            insets
        }

        if (onBoardingFinished()) {

            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        } else {

            Handler().postDelayed({
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        }

    }


    private fun onBoardingFinished(): Boolean {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)

        return sharedPreferences.getBoolean("Finished", false)
    }
}
