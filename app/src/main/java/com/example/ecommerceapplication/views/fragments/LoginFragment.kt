package com.example.ecommerceapplication.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.ecommerceapplication.R
import com.example.ecommerceapplication.shop.views.fragments.ShopRecyclerViewFragment
import com.example.ecommerceapplication.views.activities.HomeActivity
import com.example.ecommerceapplication.views.viewmodels.AuthenticationViewModel
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {
    private lateinit var emailResult: String
    private lateinit var passwordResult: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var checkBoxValue = 0
        val viewModel = AuthenticationViewModel()

        val checkBoxShop = view.findViewById<CheckBox>(R.id.checkBox_shop)
        val checkBoxBlog = view.findViewById<CheckBox>(R.id.checkBox_blog)

        var emailTextInput = view.findViewById<TextInputEditText>(R.id.textInput_Email)
        var passwordPasswordTextInput = view.findViewById<TextInputEditText>(R.id.textInput_Password)

        var loginButton = view.findViewById<AppCompatButton>(R.id.button_Login)
        var registerbutton = view.findViewById<AppCompatButton>(R.id.button_Register)

        checkBoxShop.setOnCheckedChangeListener{_,view ->
            checkBoxBlog.isChecked = !view
            checkBoxValue = 1
        }
        checkBoxBlog.setOnCheckedChangeListener{_,view ->
            checkBoxShop.isChecked = !view
            checkBoxValue = 2
        }
        loginButton.setOnClickListener{

            if (checkBoxValue == 0){
                Toast.makeText(activity?.applicationContext,"please select a checkBox",Toast.LENGTH_SHORT).show()
            }else {

                emailResult = viewModel.checkEmail(emailTextInput.text.toString())
                passwordResult = viewModel.checkPassword(passwordPasswordTextInput.text.toString())

                val myIntent = Intent(activity, HomeActivity::class.java)
                myIntent.putExtra("checkBox", checkBoxValue)
                startActivity(myIntent)
            }
        }

        registerbutton.setOnClickListener{

                val fragment: Fragment? =

                    activity?.supportFragmentManager?.findFragmentByTag(RegisterFragment::class.java.simpleName)

                if (fragment !is RegisterFragment) {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(
                            R.id.fragment_container_authentication,
                            RegisterFragment(),
                            RegisterFragment::class.java.simpleName
                        )
                        ?.commit()
                }
            }
        }
    }
