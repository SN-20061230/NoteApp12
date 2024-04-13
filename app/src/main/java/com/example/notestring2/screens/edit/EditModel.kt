package com.example.notestring.screens.edit

import com.example.notestring2.database.ExpanseDao
import com.example.notestring2.database.ExpenseEntity


class EditModel(private val appDao : ExpanseDao) {

    fun getNote(id:Int): ExpenseEntity {
        return appDao.getNote(id)
    }
    fun edit(expense: ExpenseEntity) {
        appDao.editNote(expense)
    }
}