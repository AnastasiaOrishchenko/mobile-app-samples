package com.example.numbers.fact

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.numbers.databinding.ActivitySingleFactBinding

class SingleFactActivity : AppCompatActivity() {

    lateinit var binding: ActivitySingleFactBinding
    private lateinit var singleFactViewModel: SingleFactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleFactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = intent?.extras?.getInt("number")!!

        singleFactViewModel = ViewModelProvider(
            this,
            SingleFactViewModelFactory(number)
        ).get(SingleFactViewModel::class.java)
        singleFactViewModel.fact.observe(this, {
            binding.factText.text = it
            binding.progressBar.visibility = View.GONE
        })

    }
}