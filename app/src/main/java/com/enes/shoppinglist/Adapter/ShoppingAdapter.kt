package com.enes.shoppinglist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem
import com.enes.shoppinglist.R
import com.enes.shoppinglist.UI.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = curShoppingItem.amount.toString()

        holder.itemView.imgDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        holder.itemView.imgPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }
        holder.itemView.imgMinus.setOnClickListener {
            curShoppingItem.amount--
            if (curShoppingItem.amount <= 0) viewModel.delete(curShoppingItem)
            else viewModel.upsert(curShoppingItem)
        }
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}