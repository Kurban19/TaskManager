package com.shkiper.taskmanager.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.shkiper.taskmanager.R
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.repositories.TaskRepository
import com.shkiper.taskmanager.utils.Utils
import com.shkiper.taskmanager.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.add_task_dialog.*


class TaskDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        // Do all the stuff to initialize your custom view
        val view = inflater.inflate(R.layout.add_task_dialog, container, false)
        view.findViewById<Button>(R.id.btn_add).setOnClickListener{
            val task = Task(TaskRepository.nextChatId(), et_title.text.toString(), Utils.toTaskType(spinner.selectedItem.toString()))
            TaskRepository.add(task)
            dismiss()
        }
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener{
            dismiss()
        }

        return view
    }
}