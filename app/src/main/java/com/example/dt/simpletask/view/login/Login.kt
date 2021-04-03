package com.example.dt.simpletask.view.login

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dt.simpletask.R
import com.example.dt.simpletask.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var lViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        lViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        lViewModel.setActivity(this@Login)
        binding.logactivity = this@Login

        binding.lvm = lViewModel
        binding.lifecycleOwner = this@Login
    }


    fun checkLogin() {
        when {
            TextUtils.isEmpty(binding.PhoneNumber.text) -> {
                binding.PhoneNumber.error = resources.getString(R.string.validate_Field)
            }
            TextUtils.isEmpty(binding.Password.text) -> {
                binding.Password.error = resources.getString(R.string.validate_Field)
            }
            else -> {
                lViewModel.loginClicked()
            }
        }
    }

}