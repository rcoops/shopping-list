package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingList
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityNotFoundException

abstract class JPAShoppingListService : ShoppingListService, JpaRepository<ShoppingList, Long> {

    override fun all(): List<ShoppingList> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun one(id: Long): ShoppingList? {
        return try { getOne(id) } catch (e: EntityNotFoundException) { null }
    }
}