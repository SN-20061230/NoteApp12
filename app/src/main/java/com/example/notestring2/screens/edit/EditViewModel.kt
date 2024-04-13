package com.example.notestring.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.notestring2.database.ExpenseEntity

class EditViewModel (private val navController: NavController, val id: Int, private val model: EditModel)  {

        private val _title = MutableLiveData("")
        val title: LiveData<String> = _title

        private val _description = MutableLiveData("")
        val description: LiveData<String> = _description

        var note = ExpenseEntity()


        init {
            if (id != -1) getNotes()
        }

        private fun getNotes() {
            val n = model.getNote(id)
            _title.value = n.text
            _description.value = n.amount
            note = n
        }

        fun update(expense: ExpenseEntity) {
            updateNote()
            navController.popBackStack()

        }


        private fun updateNote() {
            val newText = title.value
            val newAmount = description.value
            val n = ExpenseEntity(note.id, note.key, newText, newAmount)
            model.edit(n)
        }

        fun updateText(newTitle: String) {
            _title.value = newTitle
        }

        fun updateAmount(newDescription: String) {
            if (newDescription.isEmpty()) {
                _description.value = ""
            }
            else{
                _description.value = newDescription

            }
        }


    }