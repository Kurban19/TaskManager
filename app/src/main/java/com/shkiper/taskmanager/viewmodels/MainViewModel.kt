package com.shkiper.taskmanager.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository

class MainViewModel : ViewModel() {

    private val taskRepository = TaskRepository
    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isDone}
            .sortedBy { it.id.toInt() }
    }

    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }

    fun addToDone(taskId: Int) {
        val task = taskRepository.find(taskId)
        task ?: return
        taskRepository.update(task.copy(isDone = true))
    }

}