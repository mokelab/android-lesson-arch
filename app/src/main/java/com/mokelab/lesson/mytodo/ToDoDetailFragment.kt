package com.mokelab.lesson.mytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mokelab.lesson.mytodo.repository.ToDoRepository

class ToDoDetailFragment: Fragment() {
/*
    private val mainViewModel: MainViewModel by activityViewModels()
    private val viewModel: ToDoDetailViewModel by viewModels(factoryProducer = {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(ToDoRepository::class.java)
                    .newInstance(mainViewModel.todoRepository)
            }
        }
    })
 */

    private var todoId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.todoId = arguments?.getLong("id")?.toInt() ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_todo_detail, container, false)

/*
        viewModel.getById(this.todoId).observe(this, Observer {
            if (it == null) return@Observer
            root.findViewById<TextView>(R.id.text_title).text = it.title
            root.findViewById<TextView>(R.id.text_content).text = it.content
        })
 */

        return root
    }
}