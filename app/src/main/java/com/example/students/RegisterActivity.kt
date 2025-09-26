package com.example.students

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.students.model.Student
import com.example.students.viewmodel.StudentsViewModel
import com.example.students.viewmodel.StudentsViewModelFactory


class RegisterActivity : AppCompatActivity() {

    private lateinit var viewModel: StudentsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(
            this,
            StudentsViewModelFactory(application)
        ).get(StudentsViewModel::class.java)

        val etName = findViewById<EditText>(R.id.etName)
        val etRegNumber = findViewById<EditText>(R.id.etRegNo)
        val etCourse = findViewById<EditText>(R.id.etCourse)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val regNumber = etRegNumber.text.toString()
            val course = etCourse.text.toString()

            if (name.isNotEmpty() && regNumber.isNotEmpty() && course.isNotEmpty()) {
                val student = Student(name = name, regNumber = regNumber, course = course)
                viewModel.insert(student)

                Toast.makeText(this, "Student registered successfully", Toast.LENGTH_SHORT).show()

                // After saving, open StudentsListActivity
                startActivity(Intent(this, StudentsListActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
