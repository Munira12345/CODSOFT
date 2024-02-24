package com.munirasapplication.app.modules.login.data.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_login),
  /**
   * TODO Add additional fields as needed
   */
  var viewRectangleFiveColor: Int? = null // Placeholder for rectangle view color
)