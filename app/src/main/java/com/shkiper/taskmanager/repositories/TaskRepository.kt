package com.shkiper.taskmanager.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import com.shkiper.taskmanager.dao.DaoAccess
import com.shkiper.taskmanager.db.TaskDataBase
import com.shkiper.taskmanager.models.Task


open class TaskRepository(context: Context) {

    private lateinit var taskDao: DaoAccess
    private lateinit var tasks: LiveData<List<Task>>


    init {
        TaskDataBase.getInstance(context)?.let {
            taskDao = it.getDaoAccess()
            tasks = taskDao.fetchAllTasks()
        }
    }

    fun loadChats(): LiveData<List<Task>> {
        return tasks
    }

    fun insert(task: Task) {
        DoInBackgroundAsync<Task> {
            taskDao.insertTask(task)
        }.execute()

        Log.d("TAG", "size of tasks -> ${tasks.value?.size}")
    }


    fun deleteTask(task: Task) {
        DoInBackgroundAsync<Task> {
            taskDao.deleteTask(task)
        }.execute()
    }

    fun updateTask(task: Task) {
        DoInBackgroundAsync<Task> {
            taskDao.updateTask(task)
        }.execute()
    }

    fun deleteAll(){
        DoInBackgroundAsync<Task>{
            taskDao.deleteAll()
        }.execute()
    }


    private class DoInBackgroundAsync<T : Any>(
        private val backgroundTask: () -> Unit
    ) : AsyncTask<T, Unit, Unit>() {
        override fun doInBackground(vararg params: T) {
            backgroundTask.invoke()
        }
    }

}