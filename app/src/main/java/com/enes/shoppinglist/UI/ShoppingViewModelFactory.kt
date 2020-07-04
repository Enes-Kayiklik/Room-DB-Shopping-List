package com.enes.shoppinglist.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enes.shoppinglist.Data.Repositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}