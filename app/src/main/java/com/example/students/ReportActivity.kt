package com.example.students

import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.students.R
import com.example.students.viewmodel.StudentsViewModel
import com.example.students.viewmodel.StudentsViewModelFactory
import kotlinx.coroutines.launch

class ReportActivity : AppCompatActivity() {

    private lateinit var studentsViewModel: StudentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        studentsViewModel = ViewModelProvider(
            this,
            StudentsViewModelFactory(application)
        ).get(StudentsViewModel::class.java)

        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val tvByCourse = findViewById<TextView>(R.id.tvByCourse)

        // Load report data
        lifecycleScope.launch {
            val students = studentsViewModel.getAllStudentsNow()
            val total = students.size
            val grouped = students.groupBy { it.course }

            // Update UI
            tvTotal.text = "Total Students: $total"

            val builder = StringBuilder("By Course:\n")
            for ((course, list) in grouped) {
                builder.append("$course: ${list.size}\n")
            }
            tvByCourse.text = builder.toString()
        }
    }
}
