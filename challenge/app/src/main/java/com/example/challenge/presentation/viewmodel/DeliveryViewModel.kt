package com.example.challenge.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.data.util.Resource
import com.example.challenge.domain.usecase.GetDeliveriesUseCase
import com.example.challenge.domain.usecase.GetDeliveryListUseCase
import com.example.challenge.domain.usecase.SaveAllDeliveriesUseCase
import com.example.challenge.domain.usecase.SaveFavDeliveryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class DeliveryViewModel(
    private val app: Application,
    private val getDeliveriesUseCase: GetDeliveriesUseCase,
    private val getDeliveryListUseCase: GetDeliveryListUseCase,
    private val saveFavDeliveryUseCase: SaveFavDeliveryUseCase,
    private val saveAllDeliveriesUseCase: SaveAllDeliveriesUseCase
) : AndroidViewModel(app) {
    val deliveries: MutableLiveData<Resource<DeliveryResponse>> = MutableLiveData()
    val localDeliveries:MutableLiveData<List<DeliveryAndFavorite>> = MutableLiveData()
    fun getDeliveris(offset: Int, limit: Int) = viewModelScope.launch(Dispatchers.IO) {
        deliveries.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {

                val apiResult = getDeliveriesUseCase.execute(offset, limit)

                apiResult.data?.let { saveAllDeliveriesToDB(it.toList()) }
                deliveries.postValue(apiResult)
            }else{
                deliveries.postValue(Resource.Error("Internet is not available"))
            }

        }catch (e:Exception){
            deliveries.postValue(Resource.Error(e.message.toString()))
        }

    }
    private suspend fun saveAllDeliveriesToDB(deliveryResponseItem: List<DeliveryResponseItem>)=viewModelScope.launch(Dispatchers.IO){
        saveAllDeliveriesUseCase.execute(deliveryResponseItem)
    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }
    //local data
    fun saveFavDelivery(favorite: Favorite) = viewModelScope.launch {
        saveFavDeliveryUseCase.execute(favorite)
    }

    fun getSavedDeliveries()=viewModelScope.launch(Dispatchers.IO) {
        localDeliveries.postValue(getDeliveryListUseCase.execute())
    }

    suspend fun saveAllDeliveries(deliveryResponseItem: List<DeliveryResponseItem>){
        saveAllDeliveriesUseCase.execute(deliveryResponseItem)
    }
}


