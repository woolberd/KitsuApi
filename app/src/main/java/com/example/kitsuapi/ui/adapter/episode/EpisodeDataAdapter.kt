package com.example.kitsuapi.ui.adapter.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsuapi.base.BaseDiffUtilItemCallback
import com.example.kitsuapi.databinding.ItemEpisodeBinding
import com.example.kitsuapi.extension.setImage

class EpisodeDataAdapter :
    ListAdapter<com.example.kitsuapi.models.episodes.DataItemEpisode, EpisodeDataAdapter.DataViewHolder>(
        BaseDiffUtilItemCallback()
    ) {
    class DataViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataItem: com.example.kitsuapi.models.episodes.DataItemEpisode) {
            binding.actionImageEpisode.setImage(dataItem.attributes.thumbnail.original)
            binding.tvInt.text = dataItem.attributes.seasonNumber.toString()
            binding.lenght.text = dataItem.attributes.length.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}