package me.cooper.rick.shoppinglist.domain

data class ShoppingListItem(val item: ShoppingItem,
                            val quantity: Int,
                            val unit: String)