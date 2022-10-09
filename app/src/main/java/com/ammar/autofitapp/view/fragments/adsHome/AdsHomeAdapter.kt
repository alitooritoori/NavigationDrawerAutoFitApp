package com.ammar.autofitapp.view.fragments.adsHome

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ammar.autofitapp.R

class AdsHomeAdapter(
    private val onClick: (String) -> Unit
): RecyclerView.Adapter<AdsHomeAdapter.AdsHomeViewHolder>() {


    private val differ = AsyncListDiffer(
        this,
        AdsHomeAdapter.DiffUtils
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ads_home_items_view, parent, false)
        return AdsHomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdsHomeViewHolder, position: Int) {
        differ.currentList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class AdsHomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(data: String) = itemView.run {
            this.findViewById<TextView>(R.id.ads_home_items_view_title).run {
                text = data
            }

            setOnClickListener {
                onClick.invoke(data)
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