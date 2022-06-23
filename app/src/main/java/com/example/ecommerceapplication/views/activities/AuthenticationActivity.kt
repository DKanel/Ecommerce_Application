package com.example.ecommerceapplication.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatButton
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.views.viewmodels.AuthenticationViewModel
import com.google.android.material.textfield.TextInputEditText

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var emailResult: String
    private lateinit var passwordResult: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        var checkBoxValue = 0
        val viewModel = AuthenticationViewModel()

        val checkBoxShop = findViewById<CheckBox>(R.id.checkBox_shop)
        val checkBoxBlog = findViewById<CheckBox>(R.id.checkBox_blog)

        var emailTextInput = findViewById<TextInputEditText>(R.id.textInput_Email)
        var passwordPasswordTextInput = findViewById<TextInputEditText>(R.id.textInput_Password)

        var loginButton = findViewById<AppCompatButton>(R.id.button_Login)
        var registerbutton = findViewById<AppCompatButton>(R.id.button_Register)

        checkBoxShop.setOnCheckedChangeListener{_,view ->
            checkBoxBlog.isChecked = !view
            checkBoxValue = 1
        }
        checkBoxBlog.setOnCheckedChangeListener{_,view ->
            checkBoxShop.isChecked = !view
            checkBoxValue = 2
        }

        loginButton.setOnClickListener{
            emailResult = viewModel.checkEmail(emailTextInput.text.toString())
            passwordResult = viewModel.checkPassword(passwordPasswordTextInput.text.toString())

                val myIntent = Intent(this, HomeActivity::class.java)
                myIntent.putExtra("checkBox",checkBoxValue)
                startActivity(myIntent)

        }
    }
}