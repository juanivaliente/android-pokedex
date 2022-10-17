package com.empirox.pokedex.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.empirox.pokedex.R
import com.empirox.pokedex.model.Pokemon

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(private val view:View) : RecyclerView.ViewHolder(view) {
        private val pokemonId:TextView = view.findViewById(R.id.textViewId)
        private val pokemonName:TextView = view.findViewById(R.id.textViewName)
        private val pokemonImage:ImageView = view.findViewById(R.id.imageViewType)

        fun bind(pokemon: Pokemon) {
            pokemonId.text = pokemon.id.toString()
            pokemonName.text = pokemon.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view:View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>(){

        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }
}