package com.mokelab.lesson.mytodo

import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mokelab.lesson.mytodo.repository.ToDoRepository

class TopFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ToDoAdapter
    private val mainViewModel: MainViewModel by activityViewModels()
    private val viewModel: TopViewModel by viewModels(factoryProducer = {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(ToDoRepository::class.java)
                    .newInstance(mainViewModel.todoRepository)
            }
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_top, container, false)

        // fab
        root.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_top_to_create)
        }

        // recycler view initialization
        this.recyclerView = root.findViewById(R.id.recycler)
        this.recyclerView.layoutManager = LinearLayoutManager(
            inflater.context,
            LinearLayoutManager.VERTICAL,
            false)
            this.adapter = ToDoAdapter(inflater, listener)
        this.recyclerView.adapter = adapter

        viewModel.todoList.observe(this, Observer {
            if (it == null) return@Observer
            this.adapter.submitList(it)
        })

        return root
    }

    private val listener = View.OnClickListener {
        val position = recyclerView.getChildAdapterPosition(it)
        val itemId = adapter.getItemId(position)

        val data = Bundle()
        data.putLong("id", itemId)

        Navigation.findNavController(it).navigate(R.id.action_top_to_detail, data)

    }
}