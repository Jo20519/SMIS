package com.example.students.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.model.Student

class StudentsAdapter(
    private val onItemClick: (Student) -> Unit
) : ListAdapter<Student, StudentsAdapter.StudentViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvRegNumber: TextView = itemView.findViewById(R.id.tvRegNumber)
        private val tvCourse: TextView = itemView.findViewById(R.id.tvCourse)

        fun bind(student: Student) {
            tvName.text = student.name
            tvRegNumber.text = student.regNumber
            tvCourse.text = student.course

            itemView.setOnClickListener {
                onItemClick(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }
}
