package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.concurrent.atomic.AtomicLong

@Service
@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class InMemoryShoppingListService(private val shoppingLists: MutableMap<Long, ShoppingList> = mutableMapOf()) :
        ShoppingListService {

    override fun addItemToList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        if (shoppingList.id == null) throw Exception("no id!!")
        val originalShoppingList = one(shoppingList.id) ?: throw Exception("no list exists")
        if (shoppingList != originalShoppingList) throw Exception("lists don't match")
        val updatedShoppingList = shoppingList.copy(items = shoppingList.items.plus(shoppingListItem))
        shoppingLists[updatedShoppingList.id!!] = updatedShoppingList
        return updatedShoppingList
    }

    override fun removeItemFromList(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        if (shoppingList.id == null) throw Exception("no id!!")
        return shoppingList
    }

    override fun new(shoppingList: ShoppingList): ShoppingList? {
        val newList = shoppingList.copy(id = idGenerator.incrementAndGet())
        shoppingLists[newList.id!!] = newList
        return newList
    }

    override fun new(name: String, user: AppUser): ShoppingList? =
        if (name.isBlank()) null else  new(ShoppingList(name.trim(), setOf(user)))

    override fun one(id: Long): ShoppingList? = shoppingLists[id]

    override fun some(vararg ids: Long?): List<ShoppingList> = ids.mapNotNull { shoppingLists[it] }

    override fun all(): List<ShoppingList> = shoppingLists.values.toList()

    override fun change(id: Long?, shoppingList: ShoppingList): ShoppingList? {
        TODO()
    }

    override fun remove(shoppingList: ShoppingList): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeById(id: Long?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun totalCount(): Int = shoppingLists.size

    companion object {
        private val idGenerator = AtomicLong()
    }

}