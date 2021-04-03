package com.example.dt.simpletask.view.mainactivity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dt.simpletask.model.repositories.Repository
import com.example.dt.simpletask.model.entities.GeneralResponse
import com.example.dt.simpletask.model.entities.ConcatedAPIResult
import com.example.dt.simpletask.model.entities.Top_Slider
import com.example.dt.simpletask.model.entities.trending_new
import com.example.dt.simpletask.utilities.initializeProgressDialog
import com.example.dt.simpletask.utilities.showProgressDialog
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel  : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Activity
    private lateinit var repository: Repository

    companion object {
        var isSkipped: Boolean = true
    }

    private val resultOfConcatedAPI = MutableLiveData<ConcatedAPIResult?>()


    fun setActivity(context: Activity) {
        this.context = context
        repository = Repository()
        getTopSlidesasdr()
    }

    /**
     * here i used kotlin coroutines i could use RXJAVA
     * i will make the api return single and make ZIP function to concat the result of 2 APIs
     * but coroutines is better here as iam using kotlin
     * **/
    private fun getTopSlidesasdr() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initializeProgressDialog(context)
        }
        viewModelScope.launch {
            try {

                coroutineScope {
                    showProgressDialog(true)
                    val trendingAPI: GeneralResponse<trending_new>?
                    val categoryiesAPI: GeneralResponse<Top_Slider>?
                    val call1 = async { repository.getHome() }
                    val call2 = async { repository.getCat() }


                    trendingAPI = try {
                        call1.await()
                    } catch (ex: Exception) {
                        Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
                        null
                    }
                    categoryiesAPI = try {
                        call2.await()
                    } catch (ex: Exception) {
                        showProgressDialog(false)
                        Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
                        null
                    }

                    val resultOfConcatedAPIs = ConcatedAPIResult()
                    resultOfConcatedAPIs.setcategories(trendingAPI?.getData()?.getcategories())
                    resultOfConcatedAPIs.settrending(trendingAPI?.getData()?.gettrending())
                    resultOfConcatedAPIs.setwhats_new(trendingAPI?.getData()?.getwhats_new())
                    resultOfConcatedAPIs.setCategoriesTopSlider(categoryiesAPI?.getData()?.getCategoriesTopSlider())

                    resultOfConcatedAPI.postValue(resultOfConcatedAPIs)
                }
            } catch (Ex: Exception) {
                showProgressDialog(false)
                resultOfConcatedAPI.postValue(null)
            }
        }
    }

    fun getAllData(): LiveData<ConcatedAPIResult?> {
        return resultOfConcatedAPI
    }
}
