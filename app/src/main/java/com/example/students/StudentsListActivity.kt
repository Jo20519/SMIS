package com.example.students

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students.adapter.StudentsAdapter
import com.example.students.model.Student
import com.example.students.viewmodel.StudentsViewModel
import com.example.students.viewmodel.StudentsViewModelFactory

class StudentsListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentsAdapter
    private lateinit var viewModel: StudentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        recyclerView = findViewById(R.id.recyclerViewStudents)
        adapter = StudentsAdapter { student -> onStudentClicked(student) }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Create ViewModel using factory
        val factory = StudentsViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(StudentsViewModel::class.java)

        // Observe LiveData
        viewModel.allStudents.observe(this, Observer { students ->
            adapter.submitList(students)
        })
    }

    private fun onStudentClicked(student: Student) {
        val intent = Intent(this, StudentDetailsActivity::class.java).apply {
            putExtra("name", student.name)
            putExtra("regNumber", student.regNumber)
            putExtra("course", student.course)
        }
        startActivity(intent)
    }
}
