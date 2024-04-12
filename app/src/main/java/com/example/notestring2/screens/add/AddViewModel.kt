package com.example.notestring.screens.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.notestring2.database.ExpenseEntity

class AddViewModel(
    private val navController: NavController,
    val id: Int,
    private val model: AddModel
) {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    private val _amount = MutableLiveData("")
    val amount: LiveData<String> = _amount

    var expense = ExpenseEntity()

    fun onAdd(expense: ExpenseEntity) {
        model.addExpense(expense)
        navController.popBackStack()


    }
    fun updateText(newText: String) {
        _text.value = newText
    }

    fun updateAmount(newAmount: String) {
        if (newAmount.isEmpty()) _amount.value = ""
        else _amount.value = newAmount
    }
}