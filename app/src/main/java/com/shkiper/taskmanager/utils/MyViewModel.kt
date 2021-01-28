package com.shkiper.taskmanager.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shkiper.taskmanager.repositories.TaskRepository
import com.shkiper.taskmanager.viewmodels.MainViewModel


class MyViewModelFactory(private val taskRepository: TaskRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(taskRepository) as T
    }

}