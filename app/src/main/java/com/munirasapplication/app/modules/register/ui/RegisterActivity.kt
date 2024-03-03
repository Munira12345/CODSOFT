package com.munirasapplication.app.modules.register.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity
import com.munirasapplication.app.modules.login.ui.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()

        val edtEmailAddress: EditText = findViewById(R.id.edtEmailAddress)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        val txtSignIn: TextView = findViewById(R.id.txtSignIn)

        txtSignIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSignUp.setOnClickListener {
            val email = edtEmailAddress.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, HomescreenActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val errorMessage = task.exception?.message
                            Toast.makeText(
                                this,
                                "Registration not successful: $errorMessage",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(
                    this,
                    "Please enter both email and password.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

/*

companion object {
    const val TAG: String = "REGISTER_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, RegisterActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
    }
}
}

 */