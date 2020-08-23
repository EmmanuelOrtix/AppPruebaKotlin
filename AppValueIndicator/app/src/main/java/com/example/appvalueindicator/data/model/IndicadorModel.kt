package com.example.appvalueindicator.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndicadorModel (
    @SerializedName("nombre")
    val nombre:String,
    @SerializedName("valor")
    val valor:String,
    @SerializedName("codigo")
    val codigo:String,
    @SerializedName("unidad_medida")
    val unidadMedida:String,
    @SerializedName("fecha")
    val fecha:String
):Parcelable

data class IndicadorList(
    @SerializedName("uf")
    val indicadorList: List<IndicadorModel>
)


/*
* {
    "version": "1.6.0",
    "autor": "mindicador.cl",
    "fecha": "2020-08-22T20:00:00.000Z",
    "uf": {
        "codigo": "uf",
        "nombre": "Unidad de fomento (UF)",
        "unidad_medida": "Pesos",
        "fecha": "2020-08-22T04:00:00.000Z",
        "valor": 28671.12
    },
* */