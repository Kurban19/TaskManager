package com.shkiper.taskmanager.viewmodels
import androidx.lifecycle.*
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository


class MainViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val tasks = Transformations.map(taskRepository.loadChats()) { tasks ->
        return@map tasks.filter {!it.isComplete}
            .sortedBy { it.taskId }
    }


    fun getTaskData(): LiveData<List<Task>> {
        return tasks
    }


//    fun addToDone(taskId: Int) {
//        val task = taskRepository.find(taskId)
//        task ?: return
//        taskRepository.update(task.copy(isComplete = true))
//    }
//
//    fun restoreFromDone(taskId: Int) {
//        val task = taskRepository.find(taskId)
//        task ?: return
//        taskRepository.update(task.copy(isComplete = false))
//    }



}