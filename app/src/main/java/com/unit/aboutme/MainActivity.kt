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

    private val myName : MyName = MyName("Akshat Datt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.btnSubmitNickName.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
        binding.apply {
            myName?.nickName = etNickName.text.toString()
            invalidateAll()
            etNickName.visibility = View.GONE
            view.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        val keyboardTouchPad = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboardTouchPad.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
