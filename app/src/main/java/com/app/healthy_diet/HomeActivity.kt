package com.app.healthy_diet
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates

class HomeActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homeactivty)
        supportActionBar?.hide()

        val click= findViewById<Button>(R.id.click_here)
        click.setOnClickListener {
            val intent= Intent(this,itemsActivity::class.java)
            startActivity(intent)
        }

        val settings= arrayOf("About","Logout")
        val settingsIcon= findViewById<ImageView>(R.id.icon_settings)
        settingsIcon.setOnClickListener {
            val intent= Intent(this, settingsactivity::class.java)
            startActivity(intent)
        }




/*       fun makeTextViewDisappear(){
//            welcome_txt.setVisibility(View.VISIBLE);
//            new Handler().postDelayed(new Runnable() {
//
//                 fun run() {
//                    welcome_txt.setVisibility(View.INVISIBLE);
//                    // OR yourTV.setVisibility(View.GONE) to reclaim the space used by textview
//                }
//            }, 10000); //for 10 seconds
//        }*/

        fun onClick(view: View?) {

            auth.signOut()
            val page = Intent(this, LogIn::class.java)
            //to pass information from one activity to another activity use putExta()
            page.putExtra("myuser", "Eleazar")
            startActivity(page)
        }

//        findViewById<ImageView>(R.id.icon_logout).setOnClickListener(View.OnClickListener {
//            auth.signOut()
//            val page = Intent(this, LogIn::class.java)
//            //to pass information from one activity to another activity use putExta()
//            startActivity(page)
//
//
//        })
    }
}