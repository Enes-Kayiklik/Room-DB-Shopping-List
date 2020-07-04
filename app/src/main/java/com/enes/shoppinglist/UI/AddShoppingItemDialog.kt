package com.enes.shoppinglist.UI

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.enes.shoppinglist.Data.DB.Entites.ShoppingItem
import com.enes.shoppinglist.R
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = edtName.text.toString()
            val amount = edtAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(
                    context,
                    "Tüm bilgileri doldurduğunuzdan emin olun.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}