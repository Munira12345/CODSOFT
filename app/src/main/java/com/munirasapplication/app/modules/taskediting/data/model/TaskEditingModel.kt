package com.munirasapplication.app.modules.taskediting.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class TaskEditingModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEditActivity: String? = MyApp.getInstance().resources.getString(R.string.lbl_edit_activity)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFifteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSeventeenValue: String? = null
)
