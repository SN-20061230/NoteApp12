package com.example.notestring.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.notestring2.database.ExpenseEntity

class EditViewModel (private val navController: NavController,
                     val id: Int,
                     private val model: EditModel)   {

        private val _text = MutableLiveData("")
        val text: LiveData<String> = _text

        private val _amount = MutableLiveData("")
        val amount: LiveData<String> = _amount

        var expense = ExpenseEntity()


        init {
            if (id != -1) loadExpense()
        }


        private fun loadExpense() {
            val ex = model.getExpense(id)
            _text.value = ex.text
            _amount.value = ex.amount
            expense = ex
        }

        fun onAddUpdate(expense: ExpenseEntity) {
            updateExpense()
            navController.popBackStack()

        }


        private fun updateExpense() {
            val newText = text.value
            val newAmount = amount.value
            val ex = ExpenseEntity(expense.id, expense.key, newText, newAmount)
            model.update(ex)
        }

        fun updateText(newText: String) {
            _text.value = newText
        }

        fun updateAmount(newAmount: String) {
            if (newAmount.isEmpty()) _amount.value = ""
            else _amount.value = newAmount
        }


    }