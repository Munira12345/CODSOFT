package com.munirasapplication.app.modules.addingnewtask.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityAddingNewTaskBinding
import com.munirasapplication.app.modules.addingnewtask.`data`.viewmodel.AddingNewTaskVM
import kotlin.String
import kotlin.Unit

class AddingNewTaskActivity :
    BaseActivity<ActivityAddingNewTaskBinding>(R.layout.activity_adding_new_task) {
  private val viewModel: AddingNewTaskVM by viewModels<AddingNewTaskVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addingNewTaskVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ADDING_NEW_TASK_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddingNewTaskActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
