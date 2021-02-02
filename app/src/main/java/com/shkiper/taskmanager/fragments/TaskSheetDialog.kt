package com.shkiper.taskmanager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shkiper.taskmanager.MainActivity
import com.shkiper.taskmanager.R
import com.shkiper.taskmanager.models.Task
import com.shkiper.taskmanager.utils.Utils
import kotlinx.android.synthetic.main.task_bottom_sheet.*

class TaskSheetDialog : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add.setOnClickListener{
            if(et_title.text.isNotEmpty()){
                val task = Task(et_title.text.toString(), Utils.toTaskType(spinner.selectedItem.toString()))
                (activity as MainActivity?)!!.addTask(task)
                dismiss()
            }
            else{
                Toast.makeText(activity, getString(R.string.empty_title_error), Toast.LENGTH_LONG).show()
            }
        }

    }

}