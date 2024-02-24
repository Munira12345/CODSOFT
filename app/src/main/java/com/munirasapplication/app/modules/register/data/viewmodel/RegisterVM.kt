package com.munirasapplication.app.modules.register.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.register.data.model.RegisterModel

class RegisterVM : ViewModel() {
  val registerModel: MutableLiveData<RegisterModel> = MutableLiveData(RegisterModel())
}