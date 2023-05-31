package com.yunusbalikci.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.yunusbalikci.loginapp.databinding.ActivityDetailBinding
import com.yunusbalikci.loginapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(
                Intent(this,MainActivity::class.java)
            )
            finish()
        }

    }
}