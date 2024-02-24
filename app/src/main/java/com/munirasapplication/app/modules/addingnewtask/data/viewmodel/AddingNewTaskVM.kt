package com.munirasapplication.app.modules.addingnewtask.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.addingnewtask.`data`.model.AddingNewTaskModel
import org.koin.core.KoinComponent

class AddingNewTaskVM : ViewModel(), KoinComponent {
  val addingNewTaskModel: MutableLiveData<AddingNewTaskModel> =
      MutableLiveData(AddingNewTaskModel())

  var navArguments: Bundle? = null
}
