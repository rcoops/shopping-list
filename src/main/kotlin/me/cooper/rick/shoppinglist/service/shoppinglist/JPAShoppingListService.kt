package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityNotFoundException

abstract class JPAShoppingListService : ShoppingListService, JpaRepository<ShoppingList, Long> {

    override fun all(): List<ShoppingList> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun one(id: Long): ShoppingList? {
        return try { getOne(id) } catch (e: EntityNotFoundException) { null }
    }

    override fun new(name: String, user: AppUser): ShoppingList? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun new(it: ShoppingList): ShoppingList? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun some(vararg ids: Long?): List<ShoppingList> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun change(id: Long?, entity: ShoppingList): ShoppingList? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(entity: ShoppingList): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeById(id: Long?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun totalCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}