package com.mokelab.lesson.mytodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mokelab.lesson.mytodo.db.ToDo

class ToDoAdapter(private val inflater: LayoutInflater,
                  private val listener: View.OnClickListener): ListAdapter<ToDo, ToDoAdapter.ViewHolder>(callbacks) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = inflater.inflate(R.layout.item_todo, parent, false)
        root.setOnClickListener(this.listener)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = getItem(position)
        holder.titleText.text = todo.title
    }

    override fun getItemId(position: Int) = getItem(position).id.toLong()

    companion object {
        private val callbacks = object : DiffUtil.ItemCallback<ToDo>() {
            override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) =
                oldItem.equals(newItem)
        }
    }

    class ViewHolder(root: View): RecyclerView.ViewHolder(root) {
        val titleText = root.findViewById<TextView>(R.id.text_title)
    }
}