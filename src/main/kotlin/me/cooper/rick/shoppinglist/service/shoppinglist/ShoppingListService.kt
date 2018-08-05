package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import me.cooper.rick.shoppinglist.service.CRUDService

interface ShoppingListService: CRUDService<ShoppingList> {

    fun new(name: String, user: AppUser): ShoppingList?
    fun addItem(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList
    fun removeItem(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList

}