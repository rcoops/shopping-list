package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem

interface ShoppingListService {

  fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList?
  fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList?

}
