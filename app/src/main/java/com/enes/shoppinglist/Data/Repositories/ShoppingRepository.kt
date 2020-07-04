package com.enes.shoppinglist.Data.Repositories

import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem
import com.enes.shoppinglist.Data.DB.ShoppingDatabase

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upser(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}