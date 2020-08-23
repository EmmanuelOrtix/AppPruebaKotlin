package com.example.appvalueindicator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appvalueindicator.R
import com.example.appvalueindicator.data.model.IndicadorModel
import kotlinx.android.synthetic.main.fragment_detail_indicator.*
import kotlinx.android.synthetic.main.indicador_row.*

class DetailIndicatorFragment : Fragment() {

    private lateinit var indicador:IndicadorModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            indicador = it.getParcelable("indicador")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_indicator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        txt_nombre_detalle.text = indicador.nombre
        txt_valor.text = indicador.valor
        txt_codigo_detalle.text = indicador.codigo
        txt_unidadMedida_detalle.text = indicador.unidadMedida
        txt_fecha_detalle.text = indicador.fecha*/
    }
}