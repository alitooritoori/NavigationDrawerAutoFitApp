package com.ammar.autofitapp.view.fragments.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ammar.autofitapp.R

class ProductsAdapter(
    private val onProductClick:(String) -> Unit
): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private val differ = AsyncListDiffer(
        this,
        DiffUtils
    )
    var items: List<String> = emptyList()
        set(value) {
            field = value
            differ.submitList(ArrayList(value))
        }

    init {
        differ.submitList(items)
    }

    fun submitList(list: List<String>) {
        differ.submitList(arrayListOf())
        items = list
        differ.submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_items_view,parent, false)

        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        differ.currentList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(data: String) = itemView.run {
            this.findViewById<TextView>(R.id.products_items_view_title).run {
                text = data
            }
//            this.findViewById<TextView>(R.id.products_items_view_subtitle).run {
//
//            }
            // on item view click
            setOnClickListener {
                onProductClick.invoke(data)
            }
        }
    }

    private object DiffUtils : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String, newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String, newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }
}