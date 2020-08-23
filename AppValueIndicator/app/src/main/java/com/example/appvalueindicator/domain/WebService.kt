package com.example.appvalueindicator.domain

import com.example.appvalueindicator.data.model.IndicadorList
import retrofit2.http.GET

interface WebService {

    @GET("api")
    suspend fun getIndicadorList(): IndicadorList
}