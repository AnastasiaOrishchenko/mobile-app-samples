package com.example.numbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.widget.addTextChangedListener
import com.example.numbers.databinding.ActivityMainBinding
import com.example.numbers.fact.SingleFactActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chooseRandomButton.setOnClickListener { chooseRandom() }
        binding.findFactButton.setOnClickListener { navigateToFactScreen() }
        binding.numberInput.addTextChangedListener {
            binding.findFactButton.isEnabled = it?.toString()?.isNotBlank() ?: false
        }
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