package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.domain.ShoppingListItem
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityNotFoundException

abstract class JPAShoppingListCRUDService : ShoppingListCRUDService, JpaRepository<ShoppingList, Long> {

  override fun all(): List<ShoppingList> = findAll()

  override fun one(id: Long): ShoppingList? = try { getOne(id) } catch (e: EntityNotFoundException) { null }

  override fun new(name: String, user: AppUser): ShoppingList? = saveAndFlush(ShoppingList(name, user))

  override fun new(entity: ShoppingList): ShoppingList? = saveAndFlush(entity)

  override fun some(vararg ids: Long?): List<ShoppingList> = findAllById(ids.toList())

  override fun change(entity: ShoppingList): ShoppingList? {
    entity.id?.let { return saveAndFlush(entity) }
    throw Exception("no id")
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