package com.example.notestring.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.notestring2.database.ExpenseEntity

class HomeViewModel(private val navController: NavController, private val homeModel: HomeModel) {
    private var _list: MutableLiveData<List<ExpenseEntity>> = MutableLiveData(listOf())
    var list: LiveData<List<ExpenseEntity>> = _list

    fun getFullList() {
        _list.value = homeModel.getAllExpense()
    }

    fun onAdd() {
        val id = -1
        navController.navigate("add_screen/$id")
    }

    fun delete(expenseEntity: ExpenseEntity) {
        homeModel.onDelete(expenseEntity)
        getFullList()
    }

    fun onUpdate(expenseEntity: ExpenseEntity) {
        navController.navigate("edit_screen/${expenseEntity.id}")
    }


}