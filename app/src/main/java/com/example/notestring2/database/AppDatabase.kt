package com.example.notestring2.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update

@Entity
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var key: String? = null,
    var text: String? = null,
    var amount: String? = null,
    ){
    constructor():this(0,"","","")
}

@Dao
interface ExpanseDao{
    @Query("select * from ExpenseEntity where id = :expenseId")
    fun getNote(expenseId:Int):ExpenseEntity

    @Insert
    fun addNote(expense: ExpenseEntity)

    @Update
    fun editNote(expense: ExpenseEntity)

    @Delete
    fun deleteNote(expense: ExpenseEntity)

    @Query("select * from ExpenseEntity")
    fun getAllNotes(): List<ExpenseEntity>

//    @Query("select * from ExpenseEntity order by date")
//    fun sortByDate():List<ExpenseEntity>
}

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getDao(): ExpanseDao

    companion object{
        private var instance : AppDataBase? = null
        fun getInstance(context: Context): AppDataBase{
            if (instance==null){
                instance = Room.databaseBuilder(context, AppDataBase::class.java, "app_dp").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}