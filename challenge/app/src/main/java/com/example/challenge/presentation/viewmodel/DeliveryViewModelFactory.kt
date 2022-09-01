package com.example.challenge.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenge.domain.usecase.GetDeliveriesUseCase
import com.example.challenge.domain.usecase.GetDeliveryListUseCase
import com.example.challenge.domain.usecase.SaveAllDeliveriesUseCase
import com.example.challenge.domain.usecase.SaveFavDeliveryUseCase

class DeliveryViewModelFactory(
        private val app: Application,
        private val getDeliveriesUseCase: GetDeliveriesUseCase,
        private val getDeliveryListUseCase: GetDeliveryListUseCase,
        private val saveFavDeliveryUseCase: SaveFavDeliveryUseCase,
        private val saveAllDeliveriesUseCase: SaveAllDeliveriesUseCase
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DeliveryViewModel(
                app,
                getDeliveriesUseCase,
                getDeliveryListUseCase,
                saveFavDeliveryUseCase,
                saveAllDeliveriesUseCase
            ) as T
        }
    }
