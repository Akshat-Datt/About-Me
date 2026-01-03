package com.unit.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.unit.aboutme.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSubmitNickName.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){

        binding.tvNickName.text = binding.etNickName.text
        binding.etNickName.visibility = View.GONE
        view.visibility = View.GONE
        binding.tvNickName.visibility = View.VISIBLE

        val keyboardTouchPad = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboardTouchPad.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
