package com.example.notestring.screens.add

import com.example.notestring2.database.ExpanseDao
import com.example.notestring2.database.ExpenseEntity


class AddModel(private val appDao : ExpanseDao) {

    fun addExpense(expense: ExpenseEntity){
        appDao.addExpense(expense)

    }
}