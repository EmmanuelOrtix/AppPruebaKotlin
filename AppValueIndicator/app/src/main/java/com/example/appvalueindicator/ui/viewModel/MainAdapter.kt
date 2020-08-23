package com.example.appvalueindicator.ui.viewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.appvalueindicator.R
import com.example.appvalueindicator.base.BaseViewHolder
import com.example.appvalueindicator.data.model.IndicadorModel
import kotlinx.android.synthetic.main.indicador_row.view.*

class MainAdapter(
    private val context: Context,
    private val indicadorList: List<IndicadorModel>,
    private val itemClickListener: OnIndicadorClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface  OnIndicadorClickListener{
        fun onIndicadorClick(indicador: IndicadorModel)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.indicador_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(indicadorList[position],position)
            else -> throw IllegalAccessException("ocurrio un error en el viewHolder")
        }
    }

    override fun getItemCount(): Int = indicadorList.size

    inner class MainViewHolder(itemView: View) : BaseViewHolder<IndicadorModel>(itemView) {
        override fun bind(item: IndicadorModel, position: Int) {
            itemView.txt_nombre.text = item.nombre
            itemView.txt_valor.text = item.valor

            //accion para el click de los objetos
            itemView.setOnClickListener { itemClickListener.onIndicadorClick(item) }
        }

    }
}