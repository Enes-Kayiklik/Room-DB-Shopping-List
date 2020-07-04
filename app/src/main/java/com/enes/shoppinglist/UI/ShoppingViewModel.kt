package com.enes.shoppinglist.UI

import androidx.lifecycle.ViewModel
import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem
import com.enes.shoppinglist.Data.Repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upser(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun gelAllShoppingItem() = repository.getAllShoppingItems()

}