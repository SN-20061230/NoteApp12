package com.example.notestring.screens.edit

import com.example.notestring2.database.ExpanseDao
import com.example.notestring2.database.ExpenseEntity


class EditModel(private val appDao : ExpanseDao) {

    fun getExpense(id:Int): ExpenseEntity {
        return appDao.getExpense(id)
    }
    fun update(expense: ExpenseEntity) {
        appDao.updateExpense(expense)
    }
}