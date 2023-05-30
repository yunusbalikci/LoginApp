package com.yunusbalikci.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.yunusbalikci.loginapp.databinding.ActivityMainBinding
import com.yunusbalikci.loginapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonKayit.setOnClickListener {
            val name = binding.name.text.toString()
            val username = binding.usernamesignin.text.toString()
            val email = binding.usernamemail.text.toString()
            val password = binding.passwordsign.text.toString()
            val confirmpass = binding.passwordconfirm.text.toString()

            if(name.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmpass.isNotEmpty()){
               if (confirmpass == password){
                   firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                       if (it.isSuccessful){
                           val intent = Intent(this@RegisterActivity,MainActivity::class.java)
                           startActivity(intent)
                       } else{
                           Toast.makeText(this@RegisterActivity, it.exception.toString(), Toast.LENGTH_SHORT).show()

                       }
                   }
               }else{
                   Toast.makeText(this, "Password is not matching!", Toast.LENGTH_SHORT).show()
               }
            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}