package com.example.appvalueindicator.data

import com.example.appvalueindicator.data.model.IndicadorModel
import com.example.appvalueindicator.valueObject.Resource
import com.example.appvalueindicator.valueObject.RetrofitClient

class DataSource {

    suspend fun getIndicator(): Resource<List<IndicadorModel>>{
        return Resource.Success(RetrofitClient.webService.getIndicadorList().indicadorList)
    }
}