package com.example.sportshopapp.presentation.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sportshopapp.R
import com.example.sportshopapp.databinding.ActivityLogInBinding
import com.example.sportshopapp.presentation.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        auth = FirebaseAuth.getInstance()

        binding.tvSignIn.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


        binding.btnContinue.setOnClickListener{
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()
            val confPass = binding.etConfirmPassword.text.toString().trim()
            logInByEmailAndPass(email, pass, confPass)
        }
    }


    private fun logInByEmailAndPass(email: String, password: String, configurationPassword: String){

        if(email.isNotEmpty() && password.isNotEmpty() && configurationPassword.isNotEmpty()){
            if(password == configurationPassword){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(){
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Пороли отличаются", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Заполните поля регистрации", Toast.LENGTH_SHORT).show()
        }
    }
}