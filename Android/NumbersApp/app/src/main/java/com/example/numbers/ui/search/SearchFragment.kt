package com.example.numbers.ui.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.numbers.databinding.FragmentSearchBinding
import com.example.numbers.ui.fact.SingleFactActivity
import kotlin.random.Random

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.chooseRandomButton.setOnClickListener { chooseRandom() }
        binding.findFactButton.setOnClickListener { navigateToFactScreen() }
        binding.numberInput.addTextChangedListener {
            binding.findFactButton.isEnabled = it?.toString()?.isNotBlank() ?: false
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun chooseRandom() {
        val randomNumber = Random.nextInt(1000)
        binding.numberInput.text =
            Editable.Factory.getInstance().newEditable(randomNumber.toString())
    }

    private fun navigateToFactScreen() {
        val context = binding.findFactButton.context
        val intent = Intent(context, SingleFactActivity::class.java)
        intent.putExtra("number", Integer.valueOf(binding.numberInput.text.toString()))
        context.startActivity(intent)
    }
}