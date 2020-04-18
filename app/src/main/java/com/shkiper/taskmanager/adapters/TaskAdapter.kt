package com.shkiper.taskmanager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shkiper.taskmanager.R
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.models.TaskType
import kotlinx.android.extensions.LayoutContainer


class TaskAdapter(): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    companion object{
        private const val LOW_TYPE = 0
        private const val MEDIUM_TYPE = 1
        private const val HARD_TYPE = 2
    }

    var items: List<Task> = listOf()

    override fun getItemViewType(position: Int): Int = when(items[position].taskType){
        TaskType.LOW -> LOW_TYPE
        TaskType.MEDIUM -> MEDIUM_TYPE
        TaskType.HARD -> HARD_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            LOW_TYPE -> TaskViewHolder(inflater.inflate(R.layout.item_task_low, parent, false))
            MEDIUM_TYPE -> TaskViewHolder(inflater.inflate(R.layout.item_task_medium,parent, false))
            else -> TaskViewHolder(inflater.inflate(R.layout.item_task_hard, parent, false))
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateData(data: List<Task>){

        val diffCallback = object : DiffUtil.Callback(){
            override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean = items[oldPos].id == data[newPos].id

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = data.size

            override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean = items[oldPos].hashCode() == data[newPos].hashCode()

        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }


    inner class TaskViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView),
        LayoutContainer {
        override val containerView: View?
            get() = itemView

        var title = itemView.findViewById<TextView>(R.id.tv_title)
        //var indicator = itemView.findViewById<TextView?>(R.id.v_color)

        fun bind(item: Task){

            title.text = item.title
            //indicator.text =  item.color
        }
    }
}