package com.shkiper.taskmanager

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramijemli.percentagechartview.PercentageChartView
import com.shkiper.taskmanager.adapters.TaskAdapter
import com.shkiper.taskmanager.adapters.TaskItemTouchHelperCallback
import com.shkiper.taskmanager.fragments.TaskDialogFragment
import com.shkiper.taskmanager.utils.Utils
import com.shkiper.taskmanager.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewModel: MainViewModel
    private var sizeOfDoneTasks: Int = 0
    private var sizeOfTasks: Int = 4




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()
    }

    private fun initViews(){
        taskAdapter = TaskAdapter()
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val touchCallback = TaskItemTouchHelperCallback(taskAdapter){
            viewModel.addToDone(it.id)
        }
        val touchHelper = ItemTouchHelper(touchCallback)
        touchHelper.attachToRecyclerView(rv_task_list)

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

    private fun bindCounter(quantity: Int){
        if(quantity == 0) tv_isEmpty.visibility = View.VISIBLE else tv_isEmpty.visibility = View.GONE
        tv_doing.text = quantity.toString()
        sizeOfTasks = quantity
    }

    private fun bindDoneCounter(quantity: Int){
        tv_done.text = quantity.toString()
        pie_progress.setProgress(Utils.percentOfDone(quantity, sizeOfTasks).toFloat(), true)
    }



    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTaskData().observe(this, Observer { taskAdapter.updateData(it) })
        viewModel.getSizeOfTasks().observe(this, Observer { bindCounter(it) })
        viewModel.getSizeOfDoneTasks().observe(this, Observer { bindDoneCounter(it) })
    }



}
