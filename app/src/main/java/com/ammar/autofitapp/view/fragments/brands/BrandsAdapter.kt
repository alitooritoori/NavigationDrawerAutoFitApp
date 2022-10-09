package com.ammar.autofitapp.view.fragments.brands

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ammar.autofitapp.R
import com.bumptech.glide.Glide

class BrandsAdapter(
    private val context: Context,
    private val onClick:(Int) -> Unit
): RecyclerView.Adapter<BrandsAdapter.MViewAdapter>(){

    private val differ = AsyncListDiffer(
        this,
        DiffUtils
    )
    var items: List<Int> = emptyList()
        set(value) {
            field = value
            differ.submitList(ArrayList(value))
        }

    init {
        differ.submitList(items)
    }

    fun submitList(list: List<Int>) {
        differ.submitList(arrayListOf())
        items = list
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewAdapter {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.brands_itme_view, parent, false)

        return MViewAdapter(view)
    }

    override fun onBindViewHolder(holder: MViewAdapter, position: Int) {
       differ.currentList[position].let {
            holder.bind(it)
       }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class MViewAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(model: Int) = itemView.run {
            this.findViewById<ImageView>(R.id.brands_item_view_iv).run {

                Glide.with(context).load(model).into(this)

                setOnClickListener {
                    onClick.invoke(model)
                }
            }
        }
    }

    object DiffUtils : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(
            oldItem: Int, newItem: Int
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Int, newItem: Int
        ): Boolean {
            return oldItem == newItem
        }
    }

}
