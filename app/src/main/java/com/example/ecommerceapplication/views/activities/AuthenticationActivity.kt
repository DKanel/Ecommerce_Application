package com.example.ecommerceapplication.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.views.viewmodels.AuthenticationViewModel
import com.google.android.material.textfield.TextInputEditText

class AuthenticationActivity : AppCompatActivity() {

    val viewModel = AuthenticationViewModel()

    var emailResult = ""
    var passwordResult = ""

    var emailTextInput = findViewById<TextInputEditText>(R.id.textInput_Email)
    var passwordPasswordTextInput = findViewById<TextInputEditText>(R.id.textInput_Password)

    var loginButton = findViewById<AppCompatButton>(R.id.button_Login)
    var registerbutton = findViewById<AppCompatButton>(R.id.button_Register)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        loginButton.setOnClickListener{
            emailResult = viewModel.checkEmail(emailTextInput.text.toString())
            passwordResult = viewModel.checkPassword(passwordPasswordTextInput.text.toString())
            if (emailResult == "Success" && passwordResult == "Success"){
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
            }else{
                Toast.makeText(applicationContext,"Incorrect Email or Password ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}