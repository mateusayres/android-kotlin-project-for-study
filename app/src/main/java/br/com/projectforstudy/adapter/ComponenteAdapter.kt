package br.com.projectforstudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.projectforstudy.activity.databinding.ItemListaComponenteBinding
import br.com.projectforstudy.modelo.Componente

class ComponenteAdapter: ListAdapter<Componente, ComponenteAdapter.ComponenteViwerHolder>(DIFF) {

    var clickItemComponente: ((position:Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponenteViwerHolder {
        return ComponenteViwerHolder.create(parent, clickItemComponente)
    }

    override fun onBindViewHolder(holder: ComponenteViwerHolder, position: Int) {
        try {
            holder.bind(getItem(position),position)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    companion object{
        private val DIFF = object : DiffUtil.ItemCallback<Componente>() {
            override fun areItemsTheSame(oldItem: Componente, newItem: Componente): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Componente, newItem: Componente): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ComponenteViwerHolder (
        private val itemListaComponenteBinding: ItemListaComponenteBinding,
        private val clickItemComponente: ((position:Int) -> Unit)? = null
    ): RecyclerView.ViewHolder(itemListaComponenteBinding.root){

        fun bind(componente: Componente, position: Int){
            itemListaComponenteBinding?.tvNome?.text = componente?.nome
            itemListaComponenteBinding?.tvDescricao?.text = componente?.descricao
            itemListaComponenteBinding?.llclick?.setOnClickListener{
                clickItemComponente?.invoke(position)
            }

        }

        companion object {
            fun create(
                parent: ViewGroup,
                clickItemComponente: ((position:Int) -> Unit)? = null
            ): ComponenteViwerHolder{
                val itemListaComponenteBinding = ItemListaComponenteBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false
                )
                return ComponenteViwerHolder(itemListaComponenteBinding,clickItemComponente)
            }
        }
    }
}