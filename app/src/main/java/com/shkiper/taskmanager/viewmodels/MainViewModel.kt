package com.shkiper.taskmanager.viewmodels
import androidx.lifecycle.*
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository


class MainViewModel : ViewModel() {

    private val taskRepository = TaskRepository
    private val sizeOfTasks = taskRepository.getSizeOfTasks()
    private val sizeOfDoneTasks = taskRepository.getSizeOfDoneTasks()
    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isDone}
            .sortedBy { it.id }
    }


    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }

    fun getSizeOfDoneTasks(): LiveData<Int>{
        return sizeOfDoneTasks
    }

    fun getSizeOfTasks(): LiveData<Int> {
        return sizeOfTasks
    }

    fun addToDone(taskId: Int) {
        val task = taskRepository.find(taskId)
        task ?: return
        taskRepository.update(task.copy(isDone = true))
    }

    fun restoreFromDone(taskId: Int) {
        val task = taskRepository.find(taskId)
        task ?: return
        taskRepository.update(task.copy(isDone = false))
    }



}