package com.munirasapplication.app.modules.addingnewtask.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String


data class Task(
  val activityName: String,
  val description: String
)

data class AddingNewTaskModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTaskDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_task_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAdddetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,

  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirteenValue: String? = null
  /**
   * Task details

  var task: Task? = null
  */
)