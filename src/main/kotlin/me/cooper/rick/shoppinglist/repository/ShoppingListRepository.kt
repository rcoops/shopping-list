package me.cooper.rick.shoppinglist.repository

import me.cooper.rick.shoppinglist.domain.ShoppingList
import org.springframework.data.jpa.repository.JpaRepository

interface ShoppingListRepository: JpaRepository<ShoppingList, Long>
