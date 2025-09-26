package com.example.students

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.students.database.AppDatabase
import com.example.students.model.Student
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // classic XML layout

        // Navigate to RegisterActivity
        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Navigate to StudentsListActivity
        findViewById<Button>(R.id.btnViewStudents).setOnClickListener {
            startActivity(Intent(this, StudentsListActivity::class.java))
        }

        // Navigate to ReportActivity
        findViewById<Button>(R.id.btnReport).setOnClickListener {
            startActivity(Intent(this, ReportActivity::class.java))
        }
    }
}
