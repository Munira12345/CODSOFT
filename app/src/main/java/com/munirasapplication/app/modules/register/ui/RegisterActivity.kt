import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
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
            // Handle click on sign-in text to navigate to login screen
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSignUp.setOnClickListener {
            val email = edtEmailAddress.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isEmpty()) {
                edtEmailAddress.error = "Please enter email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                edtPassword.error = "Please enter password"
                return@setOnClickListener
            }

            // Register the user with Firebase Authentication
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registration success, navigate to home screen or desired activity
                        // For example:
                        startActivity(Intent(this, HomescreenActivity::class.java))
                        finish()
                    } else {
                        // Registration failed, handle error
                        // You can display a toast message or show an error dialog
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