package com.munirasapplication.app.modules.login.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity

class LoginActivity : AppCompatActivity() {

  private lateinit var firebaseAuth: FirebaseAuth

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    firebaseAuth = FirebaseAuth.getInstance()

    // creating my objects
    val edtEmailAddress: EditText = findViewById(R.id.edtEmailAddress)
    val edtPassword: EditText = findViewById(R.id.edtPassword)
    val btnSignIn: Button = findViewById(R.id.btnSignIn)

    btnSignIn.setOnClickListener {

      //what does this do? write it here
      // val edtEmailAddress: EditText = edtEmailAddress.findViewById(R.id.edtEmailAddress)
      // val edtPassword: EditText = edtPassword.findViewById(R.id.edtPassword)


      val email = edtEmailAddress.text.toString()
      val password = edtPassword.text.toString()

      // Sign in user with email and password
      if (email.isNotEmpty() && password.isNotEmpty()) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
          .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
              // Sign in success, we update UI with the signed-in user's information and move to homescreen
              val user = firebaseAuth.currentUser
              updateUI(user)
            } else {
              // If sign in fails, display a message to the user.
              //we'll just display a toast message
              Toast.makeText(
                baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT
              ).show()
              updateUI(null)
            }
          }

      }
    }
  }

    private fun updateUI(user: FirebaseUser?) {
      if (user != null) {
        // User is signed in, navigate to the home screen
        val intent = Intent(this, HomescreenActivity::class.java)
        startActivity(intent)
        finish() // Prevent going back to LoginActivity when pressing back button from HomeScreen
      } else {
        // User is signed out or sign-in failed
      }

  }
}

