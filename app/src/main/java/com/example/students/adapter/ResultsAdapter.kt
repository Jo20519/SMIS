package com.example.students.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.model.StudentResultDto

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>() {

    private val items = mutableListOf<StudentResultDto>()

    fun submitList(list: List<StudentResultDto>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tvName)
        private val tvReg = itemView.findViewById<TextView>(R.id.tvRegNumber)
        private val tvCourse = itemView.findViewById<TextView>(R.id.tvCourse)
        private val tvScore = itemView.findViewById<TextView>(R.id.tvScore)

        fun bind(student: StudentResultDto) {
            tvName.text = student.name
            tvReg.text = student.regNumber
            tvCourse.text = student.course
            tvScore.text = student.score.toString()
        }
    }
}
