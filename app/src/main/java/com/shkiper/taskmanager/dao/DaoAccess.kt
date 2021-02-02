package com.shkiper.taskmanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shkiper.taskmanager.models.Task

@Dao
interface DaoAccess {

    @Query("SELECT * FROM Task")
    fun fetchAllTasks(): LiveData<List<Task>>

    @Query("DELETE FROM Task")
    fun deleteAll()


    @Insert
    fun insertTask(task: Task)


    @Query("SELECT * FROM Task WHERE taskId =:taskId")
    fun getTask(taskId: Int): LiveData<Task?>?


    @Update
    fun updateTask(task: Task)


    @Delete
    fun deleteTask(task: Task)

}