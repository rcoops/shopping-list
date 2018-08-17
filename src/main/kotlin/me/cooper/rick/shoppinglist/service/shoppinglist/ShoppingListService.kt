package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import me.cooper.rick.shoppinglist.service.crud.CRUDService

interface ShoppingListService : CRUDService<ShoppingList, Long?> {

  fun new(name: String, user: AppUser): ShoppingList

  fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList

  fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList

}
