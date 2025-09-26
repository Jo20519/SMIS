package com.example.students

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvRegNumber = findViewById<TextView>(R.id.tvRegNumber)
        val tvCourse = findViewById<TextView>(R.id.tvCourse)

        // Read intent extras
        val name = intent.getStringExtra("name")
        val regNumber = intent.getStringExtra("regNumber")
        val course = intent.getStringExtra("course")

        // Display
        tvName.text = "Name: $name"
        tvRegNumber.text = "Reg Number: $regNumber"
        tvCourse.text = "Course: $course"
    }
}
