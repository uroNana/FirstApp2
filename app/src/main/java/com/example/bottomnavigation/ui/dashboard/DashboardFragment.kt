package com.example.bottomnavigation.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigation.databinding.FragmentDashboardBinding
import com.google.android.material.snackbar.Snackbar

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.actionButton.setOnClickListener {
            binding.second.text = binding.first.text
            Snackbar.make(binding.actionButton, binding.second.text, Snackbar.LENGTH_SHORT).show()
        }
        binding.first.doOnTextChanged {text, start, before, count ->
            Log.v("DashboardFragment", "edit text values: text = $text, start = $start, before = $before, count = $count")

            text?.let{
                binding.actionButton.isEnabled = it.length >= 5 && it.contains("@")
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
