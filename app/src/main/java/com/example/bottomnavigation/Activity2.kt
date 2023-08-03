package com.example.bottomnavigation

import FlagsList
import List.flagsListAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity2 : AppCompatActivity() {

    //classe senza BINDING
    //funzione ONCREATE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //associazione al layout activity2
        setContentView(R.layout.activity_2)

        //variabile con elenco delle coppie di immagini e testi presenti nella lista
        val dataList = listOf(
            FlagsList(R.drawable.image1, getString(R.string.italian_flag)),
            FlagsList(R.drawable.image2, getString(R.string.french_flag)),
            FlagsList(R.drawable.image3,  getString(R.string.union_flag))
        )

        //definizione della view della lista con id del RecycleView e dell'adapter
        val list = findViewById<RecyclerView>(R.id.flags_list)
        val adapter = flagsListAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        adapter.submitList(dataList)
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
