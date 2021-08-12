package com.example.numbers.ui.saved

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numbers.databinding.FragmentSavedBinding

const val SHARED_PREFERENCES_FILE = "com.example.numbers"
const val FACTS_LIST_KEY_VALUE = "facts"

class SavedFactsFragment : Fragment() {

    private lateinit var savedFactsViewModel: SavedFactsViewModel
    private var _binding: FragmentSavedBinding? = null
    private lateinit var recyclerViewAdapter: FactsRecyclerViewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = requireActivity()
        savedFactsViewModel =
            ViewModelProvider(
                this,
                SavedFactsViewModelFactory(
                    activity.getSharedPreferences(
                        SHARED_PREFERENCES_FILE,
                        Context.MODE_PRIVATE
                    )
                )
            ).get(SavedFactsViewModel::class.java)

        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.factsList

        savedFactsViewModel.facts.observe(activity, {
            recyclerViewAdapter = FactsRecyclerViewAdapter(it, activity)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = recyclerViewAdapter
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}