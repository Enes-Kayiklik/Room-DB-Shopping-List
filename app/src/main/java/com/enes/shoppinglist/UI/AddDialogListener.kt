package com.enes.shoppinglist.UI

import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}