package com.shkiper.taskmanager.viewmodels

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository

class MainViewModel : ViewModel() {

    private val taskRepository = TaskRepository
    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isDone}
            .sortedBy { it.id }
    }
    private val sizeOfTasks = taskRepository.getSizeOfTasks()


    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }

    fun getSizeOfTasks(): LiveData<Int> {
        return sizeOfTasks
    }

    fun addToDone(taskId: Int) {
        val task = taskRepository.find(taskId)
        task ?: return
        taskRepository.update(task.copy(isDone = true))
    }

}