package com.app.healthy_diet
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignUp : AppCompatActivity() {
   private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        supportActionBar?.hide()

        // Initialize Firebase Auth
       auth = Firebase.auth

        val logInTxt = findViewById<TextView>(R.id.logInTxt)

        logInTxt.setOnClickListener {
            val switchActivity = Intent(this, HomeActivity::class.java)
            startActivity(switchActivity)
        }

        val signUpBtn= findViewById<Button>(R.id.signup_btn)

        signUpBtn.setOnClickListener {
            performSignUp()
        }


        //let's get email and password from user




        //configure view binding
    }

    //to create a new account
    fun performSignUp(){
        val email= findViewById<EditText>(R.id.signup_email)

        val password=findViewById<EditText>(R.id.signup_password)

        if (email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Please fill all fields",Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail=email.text.toString()

        val inputPassword=password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, let's move to the next activity, i.e Home Activity
                    val intent= Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Successfully sign up",
                        Toast.LENGTH_SHORT).show()
                }

                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }

            .addOnFailureListener {
                Toast.makeText(this,"Error Occured ${it.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
            }

        

    }







}