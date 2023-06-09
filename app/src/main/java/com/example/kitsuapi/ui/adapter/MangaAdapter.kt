package com.example.kitsuapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapi.base.BaseDiffUtilItemCallback
import com.example.kitsuapi.databinding.ItemKitsuBinding
import com.example.kitsuapi.model.DataItem

class MangaAdapter(
    val onItemClick: (id: String) -> Unit
) : PagingDataAdapter<DataItem, MangaAdapter.MangaViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class MangaViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1.id) }
            }
        }

        fun onBind(attributes: DataItem) {
            binding.tvKitsu.text = attributes.attributes.titles.enJp
            Glide.with(binding.imageKitsu).load(attributes.attributes.posterImage.original)
                .into(binding.imageKitsu)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemKitsuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}