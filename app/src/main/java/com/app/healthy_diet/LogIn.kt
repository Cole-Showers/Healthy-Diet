package com.app.healthy_diet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogIn : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        supportActionBar?.hide()

        auth = Firebase.auth

        val loginbtn= findViewById<Button>(R.id.login_btn)
        loginbtn.setOnClickListener {
            performLogIn()
        }

        val signUpTxt = findViewById<TextView>(R.id.signUpTxt)

        signUpTxt.setOnClickListener {
            val switchActivity = Intent(this, SignUp::class.java)
            startActivity(switchActivity)
        }

        //to keep user logged in

         fun onStart() {
             super.onStart()
             // Check if user is signed in (non-null) and update UI accordingly.
             val currentUser: FirebaseUser? = auth.getCurrentUser()
             if (currentUser != null) {
                 val page = Intent(this@LogIn, HomeActivity::class.java)
                 //to pass information from one activity to another activity use putExta()
                 page.putExtra("myuser", "Eleazar")
                 startActivity(page)
             }
         }


    }

    //to login to existing account
    private fun performLogIn(){
        val email= findViewById<EditText>(R.id.login_email)

        val password=findViewById<EditText>(R.id.login_password)

        if (email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Please fill all fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail=email.text.toString()

        val inputPassword=password.text.toString()

        auth.signInWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, let's move to the next activity, i.e Home Activity
                    val intent= Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Log in successful",
                        Toast.LENGTH_SHORT).show()
                }

                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Log in failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }

            .addOnFailureListener {
                Toast.makeText(this,"Error Occured ${it.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
            }

    }

}


