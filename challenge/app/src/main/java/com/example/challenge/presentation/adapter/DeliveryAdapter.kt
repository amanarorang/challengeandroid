package com.example.challenge.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.challenge.R
import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.databinding.DeliveryListItemBinding
import retrofit2.Response

class DeliveryAdapter:RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<DeliveryAndFavorite>(){
        override fun areItemsTheSame(oldItem: DeliveryAndFavorite, newItem: DeliveryAndFavorite): Boolean {
            return oldItem.deliveryResponseItem.id == newItem.deliveryResponseItem.id
        }

        override fun areContentsTheSame(oldItem: DeliveryAndFavorite, newItem: DeliveryAndFavorite): Boolean {
           return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding = DeliveryListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }



    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        val delivery = differ.currentList[position]
        holder.bind(delivery)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class DeliveryViewHolder(
        val binding:DeliveryListItemBinding):
        RecyclerView.ViewHolder(binding.root){
           fun bind(deliveryAndFavorite: DeliveryAndFavorite){
               Log.i("MYTAG","came here ${deliveryAndFavorite.deliveryResponseItem.id}")
               binding.tvFromValue.text = deliveryAndFavorite.deliveryResponseItem.route.start
               binding.tvToValue.text = deliveryAndFavorite.deliveryResponseItem.route.end

               Glide.with(binding.ivDeliveryImage.context).
              load(deliveryAndFavorite.deliveryResponseItem.goodsPicture)
                   .override(150,150).
                       centerCrop().
               into(binding.ivDeliveryImage)
               binding.root.setOnClickListener {
                   onItemClickListener?.let {
                       it(deliveryAndFavorite.deliveryResponseItem)
                   }

               }
               if (deliveryAndFavorite.favorite?.isFavorite == true){
                   Glide.with(binding.ivFavoriteImage.context).
                   load(R.drawable.ic_favorite_unpressed).
                   into(binding.ivFavoriteImage)
               }
               else{
                  binding.ivFavoriteImage.visibility= View.GONE
               }

        }
           }
    private var onItemClickListener :((DeliveryResponseItem)->Unit)?=null

    fun setOnItemClickListener(listener : (DeliveryResponseItem)->Unit){
        onItemClickListener = listener
    }
        }




