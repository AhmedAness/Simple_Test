package com.example.dt.simpletask.view.login

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.dt.simpletask.model.repositories.Repository
import com.example.dt.simpletask.model.entities.User
import com.example.dt.simpletask.utilities.initializeProgressDialog
import com.example.dt.simpletask.utilities.goMain
import com.example.dt.simpletask.utilities.showProgressDialog
import com.example.dt.simpletask.view.mainactivity.MainActivityViewModel.Companion.isSkipped
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Activity
    var user = User()
    private lateinit var repository : Repository


    private var loginCompostie = CompositeDisposable()


    fun setActivity(context: Activity) {
        this.context = context
        repository = Repository()
    }


    fun loginClicked(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initializeProgressDialog(context)
        }
        loginCompostie.add(repository.login(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {

                showProgressDialog(true)
            }
            .subscribe(
                {
                    showProgressDialog(false)
                    // not verified but i will login any way
                    Toast.makeText(context,  it.getmsg(), Toast.LENGTH_LONG).show()
                    isSkipped = false
                    goMain(context)
                },
                {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    showProgressDialog(false )
                }
            ))

    }

    fun skipped(){
        isSkipped = true
        goMain(context)
    }

}
