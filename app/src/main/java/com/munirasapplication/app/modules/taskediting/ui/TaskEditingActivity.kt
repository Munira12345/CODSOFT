package com.munirasapplication.app.modules.taskediting.ui

import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityTaskEditingBinding
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity
import com.munirasapplication.app.modules.register.ui.RegisterActivity
import com.munirasapplication.app.modules.taskediting.`data`.viewmodel.TaskEditingVM
import kotlin.String
import kotlin.Unit

class TaskEditingActivity : BaseActivity<ActivityTaskEditingBinding>(R.layout.activity_task_editing)
    {
  private val viewModel: TaskEditingVM by viewModels<TaskEditingVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.taskEditingVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageUser.setOnClickListener {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageThumbsup.setOnClickListener {
      val destIntent = HomescreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    //this button listener will retain
    binding.imageHome.setOnClickListener {
      val destIntent = HomescreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnSave1.setOnClickListener {
      val destIntent = HomescreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "TASK_EDITING_ACTIVITY"

  }
}
