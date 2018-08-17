package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class DummyShoppingListService(private val shoppingLists: MutableMap<Long, ShoppingList> = mutableMapOf()) :
    AbstractShoppingListService() {

    override fun new(shoppingList: ShoppingList): ShoppingList {
        val newList = shoppingList.copy(id = idGenerator.incrementAndGet())
        shoppingLists[newList.id!!] = newList
        return newList
    }

    override fun new(name: String, user: AppUser): ShoppingList = new(ShoppingList(name.trim(), setOf(user)))

    override fun one(id: Long): ShoppingList? = shoppingLists[id]

    override fun some(vararg ids: Long?): List<ShoppingList> = ids.mapNotNull { shoppingLists[it] }

    override fun all(): List<ShoppingList> = shoppingLists.values.toList()


    @Throws(IllegalArgumentException::class)
    override fun change(shoppingList: ShoppingList): ShoppingList {
        return shoppingList.id?.let { shoppingLists[it] = shoppingList; shoppingList }
            ?: throw IllegalArgumentException("no id!!")
    }

    override fun remove(shoppingList: ShoppingList) {
        removeById(shoppingList.id)
    }

    override fun removeById(id: Long?) {
        id?.let { shoppingLists.remove(it) }
    }

    override fun totalCount(): Long = shoppingLists.size.toLong()

    companion object {
        private val idGenerator = AtomicLong()
    }

}