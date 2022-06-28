package com.example.ecommerceapplication.views.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.ecommerceapplication.R
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class RegisterFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<Button>(R.id.button_back_register)
        val submitButton = view.findViewById<Button>(R.id.button_submit_register)
        val emailTextInput = view.findViewById<TextInputEditText>(R.id.textinputedittext_email_register)
        val passwordTextInput = view.findViewById<TextInputEditText>(R.id.textinputedittext_password_register)
        val confirmPasswordTextInput = view.findViewById<TextInputEditText>(R.id.textinputedittext_confirm_password_register)



        backButton.setOnClickListener {

            val fragment: Fragment? =

                activity?.supportFragmentManager?.findFragmentByTag(LoginFragment::class.java.simpleName)

            if (fragment !is LoginFragment){
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container_authentication, LoginFragment(), LoginFragment::class.java.simpleName)
                    ?.commit()
            }
        }

        submitButton.setOnClickListener {

            if(!Patterns.EMAIL_ADDRESS.matcher(emailTextInput.text.toString()).matches()){
                Toast.makeText(activity?.applicationContext, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            }
        }

    }
}