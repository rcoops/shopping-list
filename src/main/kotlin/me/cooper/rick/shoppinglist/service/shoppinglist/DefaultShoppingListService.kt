package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import javax.inject.Inject

class DefaultShoppingListService @Inject constructor(
    val shoppingListCRUDService: ShoppingListCRUDService): ShoppingListService {

  override fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
    if (shoppingList.id == null) throw Exception("no id!!")
    val originalShoppingList = shoppingListCRUDService.one(shoppingList.id) ?: throw Exception("no list exists")
    if (shoppingList != originalShoppingList) throw Exception("lists don't match")
    val updatedShoppingList = shoppingList.copy(items = shoppingList.items.plus(shoppingListItem))
    return shoppingListCRUDService.change(updatedShoppingList.id, updatedShoppingList)
        ?: throw Exception("wasn't persisted")
  }

  override fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
    if (shoppingList.id == null) throw Exception("no id!!")
    return shoppingList
  }

}
