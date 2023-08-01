package com.example.bottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    //definizione della variabile BINDING
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //variabile con binding del Bottom navigation view
        val navView: BottomNavigationView = binding.navView

        //variabile associata al fragment in activity main
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // variabile contenente gli id di ogni Item presente del bottom navigation menu
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        //associazione del fragment presente in activity main con gli items e il bottom nav menu
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //binding del bottone fab con funzione di testo Snackbar
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Snackbar Test", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
                //.setAnchorView(R.id.fab) per ottenere lo spostamento del fab
        }

    }

}
//TODO aggiungi file "values-sw820dp" con dimensioni adattate
//TODO aggiungi due opzioni di menu di cui una con 3 item con "app:showAsAction="never" " e
// l'altra con un item con "app:showAsAction="always" "

//TODO chiedi ad antonio la differenza tra i vari layout