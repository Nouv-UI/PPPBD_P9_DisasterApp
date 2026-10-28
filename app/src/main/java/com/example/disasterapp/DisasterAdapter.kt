package com.example.disasterapp

import Disaster
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disasterapp.databinding.ItemDisasterBinding

// Definisi alias fungsi untuk menangani event klik item
typealias OnClickDisaster = (Disaster) -> Unit

class DisasterAdapter(
    private val listDisaster: List<Disaster>,
    private val onClickDisaster: OnClickDisaster
) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    // Inner class ViewHolder untuk menghubungkan data dengan elemen tampilan item
    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Disaster) {
            with(binding) {
                txtDisasterName.text = data.nameDisaster
                txtDisasterType.text = data.disasterType
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    // Membuat tampilan baru (meng-inflate layout item_disaster.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemDisasterViewHolder(binding)
    }

    // Mengembalikan jumlah total item data
    override fun getItemCount(): Int {
        return listDisaster.size
    }

    // Mengikat data pada posisi tertentu ke ViewHolder
    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}