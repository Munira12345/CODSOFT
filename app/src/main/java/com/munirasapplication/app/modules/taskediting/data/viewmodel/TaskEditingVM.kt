package com.munirasapplication.app.modules.taskediting.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.taskediting.`data`.model.TaskEditingModel
import org.koin.core.KoinComponent

class TaskEditingVM : ViewModel(), KoinComponent {
  val taskEditingModel: MutableLiveData<TaskEditingModel> = MutableLiveData(TaskEditingModel())

  var navArguments: Bundle? = null
}
