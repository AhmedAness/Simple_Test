package com.example.dt.simpletask.utilities

import android.app.Activity
import android.content.Intent
import com.example.dt.simpletask.view.mainactivity.MainActivity

//
fun goMain(activity :Activity) {
        val mIntent = Intent(activity, MainActivity::class.java)
        activity.startActivity(mIntent)
        activity.finish()
}


