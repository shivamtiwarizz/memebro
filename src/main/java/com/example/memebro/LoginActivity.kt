package com.example.memebro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memebro.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()
//            val user = FirebaseAuth.getInstance().currentUser
//            if (user != null){
//                val intent = Intent(this, home::class.java)
//                startActivity(intent)
//
//            }
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Plz check your password or email id", Toast.LENGTH_SHORT).show()
                    }

                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }






        lateinit var auth: FirebaseAuth // Or any other authentication provider

// In your onCreate() method or wherever you initialize your auth variable
        auth = FirebaseAuth.getInstance()

// Check if the user is already logged in
        if (auth.currentUser != null) {
            // Start the main activity and clear the backstack so the user cannot go back to the login activity
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            // Finish the current activity so that it is removed from the backstack
            finish()
        }






//        binding.forgotPassword.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            val view = layoutInflater.inflate(R.layout.dialog_forgot, null)
//            val userEmail = view.findViewById<EditText>(R.id.editBox)
//            builder.setView(view)
//            val dialog = builder.create()
//            view.findViewById<Button>(R.id.btnReset).setOnClickListener {
//                compareEmail(userEmail)
//                dialog.dismiss()
//            }
//            view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
//                dialog.dismiss()
//            }
//            if (dialog.window != null){
//                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
//            }
//            dialog.show()
//        }
        binding.signupRedirectText.setOnClickListener {
            val signupIntent = Intent(this, SignupActivity::class.java)
            startActivity(signupIntent)
        }
        binding.textView6.setOnClickListener {
            val signupIntent = Intent(this, MainActivity::class.java)
            startActivity(signupIntent)
        }
    }
    //Outside onCreate
    private fun compareEmail(email: EditText){
        if (email.text.toString().isEmpty()){
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            return
        }
        firebaseAuth.sendPasswordResetEmail(email.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
                }

                }
            }
//        if (firebaseAuth.currentUser != null) {
//            val intent = Intent(this@LoginActivity, home::class.java)
//            startActivity(intent)
//        }
    }



