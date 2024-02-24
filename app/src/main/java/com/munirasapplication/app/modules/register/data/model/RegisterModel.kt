package com.munirasapplication.app.modules.register.data.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp

data class RegisterModel(
    /**
     * TODO Replace with dynamic value
     */
    var txtCreateAccount: String? = MyApp.getInstance().getString(R.string.lbl_create_account),

    /**
     * TODO Replace with dynamic value
     */
    var txtAlreadyauser: String? = MyApp.getInstance().getString(R.string.lbl_already_a_user),

    /**
     * TODO Replace with dynamic value
     */
    var txtSignIn: String? = MyApp.getInstance().getString(R.string.lbl_sign_in)
)