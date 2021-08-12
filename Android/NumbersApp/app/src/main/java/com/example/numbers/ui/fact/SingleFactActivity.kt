package com.example.numbers.ui.fact

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.numbers.databinding.ActivitySingleFactBinding
import com.example.numbers.ui.saved.SHARED_PREFERENCES_FILE

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
            SingleFactViewModelFactory(
                number,
                getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE)
            )
        ).get(SingleFactViewModel::class.java)
        singleFactViewModel.fact.observe(this, {
            binding.factText.text = it
            binding.progressBar.visibility = View.GONE
            binding.saveButton.visibility = View.VISIBLE
        })

        binding.saveButton.setOnClickListener {
            singleFactViewModel.saveFact()
            binding.saveButton.visibility = View.GONE
        }
    }
}