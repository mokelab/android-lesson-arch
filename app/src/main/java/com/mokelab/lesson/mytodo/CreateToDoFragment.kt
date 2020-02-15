package com.mokelab.lesson.mytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateToDoFragment: Fragment() {
/*
    private val mainViewModel: MainViewModel by activityViewModels()

 */

    private lateinit var titleEdit: EditText
    private lateinit var contentEdit: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_create_todo, container, false)

        this.titleEdit = root.findViewById(R.id.edit_title)
        this.contentEdit = root.findViewById(R.id.edit_content)

        root.findViewById<Button>(R.id.button_submit).setOnClickListener {
            create()
        }

        return root
    }

    private fun create() {
        val title = titleEdit.text.toString()
        val content = contentEdit.text.toString()

/*
        this.mainViewModel.viewModelScope.launch {
            withContext(Dispatchers.IO) {
                mainViewModel.todoRepository.create(title, content)
            }
            Navigation.findNavController(view!!).popBackStack()
        }
 */
    }
}