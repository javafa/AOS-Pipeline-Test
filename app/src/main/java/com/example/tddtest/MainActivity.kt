package com.example.tddtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty()) {
                textMessage.text = "이메일을 입력하세요"
            } else if (password.isEmpty()){
                textMessage.text = "비밀번호를 입력하세요"
            } else {
                textMessage.text = "$email 으로 로그인 성공!!"
            }
//            val intent = Intent(this, SubActivity::class.java)
//            startActivity(intent)
        }
    }

    fun test(){
        println("for a testing pipeline")
    }
}