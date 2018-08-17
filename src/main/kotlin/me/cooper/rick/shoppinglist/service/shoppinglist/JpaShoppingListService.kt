import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import me.cooper.rick.shoppinglist.service.shoppinglist.AbstractShoppingListService
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityNotFoundException

class JpaShoppingListService(private val shoppingListRepository: JpaRepository<ShoppingList, Long>)
  : AbstractShoppingListService() {

  override fun all(): List<ShoppingList> = shoppingListRepository.findAll()

  override fun one(id: Long): ShoppingList? {
    return try {
      shoppingListRepository.getOne(id)
    } catch (e: EntityNotFoundException) {
      null
    }
  }

  override fun new(name: String, user: AppUser): ShoppingList {
    return shoppingListRepository.saveAndFlush(ShoppingList(name, user))
  }

  // TODO save entity with pre-existing id?
  override fun new(entity: ShoppingList): ShoppingList = shoppingListRepository.saveAndFlush(entity)

  override fun some(vararg ids: Long?): List<ShoppingList> = shoppingListRepository.findAllById(ids.toList())

  @Throws(IllegalArgumentException::class)
  override fun change(entity: ShoppingList): ShoppingList {
    return entity.id?.let {  shoppingListRepository.saveAndFlush(entity) } ?: throw IllegalArgumentException("no id!!")
  }

  override fun remove(entity: ShoppingList) = shoppingListRepository.delete(entity)

  override fun removeById(id: Long?) {
    id?.let { shoppingListRepository.deleteById(it) }
  }

  override fun totalCount(): Long = shoppingListRepository.count()

}