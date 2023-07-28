package com.example.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    //classe senza BINDING
    //funzione ONCREATE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //associazione al layout activity2
        setContentView(R.layout.activity_2)

        //definizione con associazione al bottone di navigazione
        val backButton: Button = findViewById(R.id.activity2_button_navigation)

        //associazione al bottone di navigazione della funzione di navigazioni tra le attività
        // ( da Activity2 a MainActivity)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
