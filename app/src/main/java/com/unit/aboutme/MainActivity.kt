package com.unit.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unit.aboutme.ui.theme.AboutMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNickName : Button = findViewById<Button>(R.id.btn_submitNickName)

        btnNickName.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
        val nickNameInput = findViewById<EditText>(R.id.et_nickName)
        val nickNameOutput = findViewById<TextView>(R.id.tv_nickName)

        nickNameOutput.text = nickNameInput.text
        nickNameInput.visibility = View.GONE
        view.visibility = View.GONE
        nickNameOutput.visibility = View.VISIBLE

        val keyboardTouchPad = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboardTouchPad.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
