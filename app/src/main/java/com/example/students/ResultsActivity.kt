package com.example.students

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students.adapter.ResultsAdapter
import com.example.students.viewmodel.ResultsViewModel
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class ResultsActivity : AppCompatActivity() {

    private val viewModel: ResultsViewModel by viewModels()
    private lateinit var adapter: ResultsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewResults)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ResultsAdapter()
        recyclerView.adapter = adapter

        // Observe LiveData
        viewModel.results.observe(this, Observer { results ->
            adapter.submitList(results)
        })

        // Fetch from API
        viewModel.fetchResults()
    }
}