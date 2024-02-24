package com.munirasapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityLoginBinding
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity
import com.munirasapplication.app.modules.login.`data`.viewmodel.LoginVM
import kotlin.String
import kotlin.Unit

class LoginActivity : AppCompatActivity() {
 // private lateinit var firebaseAuth: FirebaseAuth

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

   // firebaseAuth = FirebaseAuth.getInstance()

    //creating all the objects

    val edtEmailAddress: EditText = findViewById(R.id.edtEmailAddress)
    val edtPassword: EditText = findViewById(R.id.edtPassword)
    val btnSignIn: Button = findViewById(R.id.btnSignIn)

    btnSignIn.setOnClickListener {
      val intent = Intent(this, HomescreenActivity::class.java)
      startActivity(intent)
    }



/*
  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

 */
}}
