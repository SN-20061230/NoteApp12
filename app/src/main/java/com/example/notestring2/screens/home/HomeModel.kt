package com.example.notestring.screens.home

import com.example.notestring2.database.ExpanseDao
import com.example.notestring2.database.ExpenseEntity


class HomeModel(private val appDao: ExpanseDao) {

    fun getAllNotes():List<ExpenseEntity>{
        return appDao.getAllNotes()
    }

    fun delete(noteEntity: ExpenseEntity){
        appDao.deleteNote(noteEntity)
    }


}