package com.shkiper.taskmanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shkiper.taskmanager.models.Task

@Dao
interface DaoAccess {

    @Query("SELECT * FROM Task")
    fun fetchAllTasks(): LiveData<List<Task>>


    @Insert
    fun insertTask(task: Task): Long?


    @Query("SELECT * FROM Task WHERE taskId =:taskId")
    fun getTask(taskId: Int): LiveData<Task?>?


    @Update
    fun updateTask(task: Task)


    @Delete
    fun deleteTask(task: Task)

}