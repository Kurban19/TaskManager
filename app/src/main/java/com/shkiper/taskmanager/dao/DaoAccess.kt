package com.shkiper.taskmanager.dao

import android.provider.ContactsContract.CommonDataKinds.Note

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shkiper.taskmanager.models.Task


interface DaoAccess {

    @Query("SELECT * FROM Task ORDER BY taskId")
    fun fetchAllTasks(): LiveData<List<Task>>


    @Insert
    fun insertTask(task: Task): Long?


    @Query("SELECT * FROM Task WHERE taskId =:taskId")
    fun getTask(taskId: Int): LiveData<Note?>?


    @Update
    fun updateTask(task: Task)


    @Delete
    fun deleteTask(task: Task)

}