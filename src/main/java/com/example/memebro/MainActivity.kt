package com.example.memebro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var button2 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    // c private lateinit var button7 : Buttonreate a alertdialog
    private lateinit var builder : AlertDialog.Builder
    private lateinit var auth: FirebaseAuth // Or any other authentication provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2 = findViewById(R.id.button2)
        // we have a simple button of id button
        // on button click we will open alert box
val buttonClick = findViewById<Button>(R.id.button3)
buttonClick.setOnClickListener {
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
}

val buttonClick1 = findViewById<Button>(R.id.button7)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.button8)
        button.setOnClickListener {
            val intent = Intent(this, testcam::class.java)
            startActivity(intent)
        }

//        val buttonClick1 = findViewById<Button>(R.id.button)
//        buttonClick1.setOnClickListener {
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//        }
        builder = AlertDialog.Builder(this)

        button2.setOnClickListener{
            builder.setTitle("HEY USER!")
                .setMessage("To upload files and memes Login/Signup first")
                .setCancelable(true) // dialog box in cancellable
                // set positive button
                //take two parameters dialogInterface and an int
                .setPositiveButton("Login"){dialogInterface,it ->
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // close the app when yes clicked
                }
//                .setNegativeButton("No"){dialogInterface,it ->
//                    // cancel the dialogbox
//                    dialogInterface.cancel()
//                }
                .setNeutralButton("Later"){dialogInterface,it ->
                    // just show a toast

                }
                // show the builder
                .show()
        }
        // Inside your activity or fragment

// In your onCreate() method or wherever you initialize your auth and logoutButton variables
        auth = FirebaseAuth.getInstance()
        button6 = findViewById(R.id.button6)

// Implement a logout button click listener
        button6.setOnClickListener {
            // Sign out the user from the authentication provider
            auth.signOut()
            // Start the login activity and clear the backstack so the user cannot go back to the previous activity
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            // Finish the current activity so that it is removed from the backstack
            finish()
        }

    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}








