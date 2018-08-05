package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
@Service
class InMemoryShoppingListService(private val shoppingLists: MutableMap<Long, ShoppingList> = mutableMapOf()) :
        ShoppingListService {


    private val idCount = AtomicLong()

    override fun addItem(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        if (shoppingList.id == null) throw Exception("no id!!")
        val originalShoppingList = one(shoppingList.id) ?: throw Exception("no list exists")
        if (shoppingList != originalShoppingList) throw Exception("lists don't match")
        val updatedShoppingList = shoppingList.copy(items = shoppingList.items.plus(shoppingListItem))
        shoppingLists[updatedShoppingList.id!!] = updatedShoppingList
        return updatedShoppingList
    }

    override fun removeItem(shoppingListItem: ShoppingListItem, shoppingList: ShoppingList): ShoppingList {
        if (shoppingList.id == null) throw Exception("no id!!")
        return shoppingList
    }

    override fun new(it: ShoppingList): ShoppingList? {
        val newList = it.copy(id = idCount.incrementAndGet())
        shoppingLists[newList.id!!] = newList
        return newList
    }

    override fun new(name: String, user: AppUser): ShoppingList? = new(ShoppingList(name, setOf(user)))

    override fun one(id: Long): ShoppingList? = shoppingLists[id]

    override fun some(vararg ids: Long): List<ShoppingList> = ids.map { shoppingLists[it] }.filterNotNull()

    override fun all(): List<ShoppingList> = shoppingLists.values.toList()

    override fun change(shoppingList: ShoppingList): ShoppingList? {
        TODO()
    }

    override fun remove(shoppingList: ShoppingList): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(id: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}