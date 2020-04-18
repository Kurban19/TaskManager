package com.shkiper.taskmanager

import android.R.string
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.shkiper.taskmanager.adapters.TaskAdapter
import com.shkiper.taskmanager.fragments.TaskDialogFragment
import com.shkiper.taskmanager.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()
    }

    private fun initViews(){
        taskAdapter = TaskAdapter()
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        with(rv_task_list){
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
        }

        add_task_btn.setOnClickListener {
            openDialog()
        }



    }

    private fun openDialog(){
        val fm: FragmentManager = supportFragmentManager
        val taskDialog = TaskDialogFragment()
        taskDialog.show(fm, "")

    }




    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTaskData().observe(this, Observer { taskAdapter.updateData(it) })
    }
}
