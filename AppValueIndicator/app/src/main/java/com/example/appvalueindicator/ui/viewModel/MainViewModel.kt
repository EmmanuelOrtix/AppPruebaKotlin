package com.example.appvalueindicator.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.appvalueindicator.domain.Repo
import com.example.appvalueindicator.valueObject.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


class MainViewModel(private val repo:Repo): ViewModel() {

    private val indicadorData = MutableLiveData<String>()

    val fetchIndicadorList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getIndicadoresList())
        }catch (e: Exception) {
        emit(Resource.Failure(e))
        }
    }


}