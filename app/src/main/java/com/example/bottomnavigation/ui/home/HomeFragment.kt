package com.example.bottomnavigation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigation.Activity2
import com.example.bottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //definizione della variabile BINDING
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //funzione ONCREATEVIEW
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //binding del bottone di navigazione tra activities (da MainActivity a Activity2)
        binding.buttonNavigation.setOnClickListener {
            val intent = Intent(requireContext(), Activity2::class.java)
            startActivity(intent)
        }

        return root
    }

    //funzione ONDESTROYVIEW
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
