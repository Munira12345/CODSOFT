package com.munirasapplication.app.modules.homescreen.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HomescreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_tasks)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDentistappoint: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dentist_appoint)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_feed_puppy)

)
