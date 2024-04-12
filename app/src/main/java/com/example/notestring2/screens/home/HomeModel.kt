package com.example.notestring.screens.home

import com.example.notestring2.database.ExpanseDao
import com.example.notestring2.database.ExpenseEntity


class HomeModel(private val appDao: ExpanseDao) {

    fun getAllExpense():List<ExpenseEntity>{
        return appDao.getAllExpenses()
    }

    fun onDelete(expenseEntity: ExpenseEntity){
        appDao.deleteExpense(expenseEntity)
    }


}