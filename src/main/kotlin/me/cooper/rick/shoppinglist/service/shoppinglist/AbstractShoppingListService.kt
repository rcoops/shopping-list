package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem

abstract class AbstractShoppingListService : ShoppingListService {

    @Throws(IllegalArgumentException::class)
    override fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        if (shoppingList.id == null) throw IllegalArgumentException("no id!!")
        val originalShoppingList = one(shoppingList.id) ?: throw Exception("no list exists")
        if (shoppingList != originalShoppingList) throw IllegalArgumentException("lists don't match")
        val updatedShoppingList = shoppingList.copy(items = shoppingList.items.plus(shoppingListItem))
        return change(updatedShoppingList)
    }

    @Throws(IllegalArgumentException::class)
    override fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        // TODO this isn't right
        return shoppingList.id?.let { shoppingList } ?: throw  IllegalArgumentException("no id!!")
    }

}