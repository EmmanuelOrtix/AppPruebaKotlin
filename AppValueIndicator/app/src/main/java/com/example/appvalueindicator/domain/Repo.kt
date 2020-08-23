package com.example.appvalueindicator.domain

import com.example.appvalueindicator.data.model.IndicadorModel
import com.example.appvalueindicator.valueObject.Resource

interface Repo {
    suspend fun getIndicadoresList(): Resource<List<IndicadorModel>>
}