package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.service.CRUDService

interface ShoppingListCRUDService: CRUDService<ShoppingList, Long?> {

    fun new(name: String, user: AppUser): ShoppingList?

}