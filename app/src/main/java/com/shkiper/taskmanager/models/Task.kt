package com.shkiper.taskmanager.models

data class Task(
    val id : String,
    var title: String,
    val color: String = "@color/color_green",
    var isDone: Boolean = false
) {
}