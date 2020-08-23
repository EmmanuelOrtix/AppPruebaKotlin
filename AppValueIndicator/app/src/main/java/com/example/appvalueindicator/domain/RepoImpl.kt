package com.example.appvalueindicator.domain

import com.example.appvalueindicator.data.DataSource
import com.example.appvalueindicator.data.model.IndicadorModel
import com.example.appvalueindicator.valueObject.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getIndicadoresList(): Resource<List<IndicadorModel>> {
        return dataSource.getIndicator()
    }


}