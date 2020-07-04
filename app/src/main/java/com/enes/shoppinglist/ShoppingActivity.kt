package com.enes.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.enes.shoppinglist.Adapter.ShoppingAdapter
import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem
import com.enes.shoppinglist.Data.DB.ShoppingDatabase
import com.enes.shoppinglist.Data.Repositories.ShoppingRepository
import com.enes.shoppinglist.UI.AddDialogListener
import com.enes.shoppinglist.UI.AddShoppingItemDialog
import com.enes.shoppinglist.UI.ShoppingViewModel
import com.enes.shoppinglist.UI.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*
import java.util.*

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.gelAllShoppingItem().observe(this, androidx.lifecycle.Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}
