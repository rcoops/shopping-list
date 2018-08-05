package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.domain.ShoppingList
import spock.lang.Specification


class ShoppingListServiceSpec extends Specification {

  private static final String NAME = "My List"
  private static final AppUser user = new AppUser(1L, "TestyMcTest", "password", "Mr Test", "test@test.com", [].toSet(), [].toSet())

  private static ShoppingListService shoppingListService

  def setup() {
    shoppingListService = new InMemoryShoppingListService()
  }

  def "the service can create an store a shopping list from a pre-created list"() {
    given: "a potential shopping list to be created"
    def listToCreate = new ShoppingList(NAME, user)

    when: "the service is called to create a new list"
    def createdList = shoppingListService.new(listToCreate)

    then: "the returned list has an id"
    createdList.id
    and: "the name of the returned list is the same as that passed"
    createdList.name == NAME
    and: "the returned list has a set containing the given user and no other"
    createdList.users == [user].toSet()

    when: "the list is then retrieved from the service"
    def retrievedList = shoppingListService.one(createdList.id)
    then: "it has been stored and is equal to that returned"
    retrievedList == createdList
  }

  def "the service can create a shopping list from name and user"() {
    when: "the service is called to create a new list"
    def createdList = shoppingListService.new(NAME, user)

    then: "the returned list has an id"
    createdList.id
    and: "the name of the returned list is the same as that passed"
    createdList.name == NAME
    and: "the returned list has a set containing the given user and no other"
    createdList.users == [user].toSet()

    when: "the list is then retrieved from the service"
    def retrievedList = shoppingListService.one(createdList.id)
    then: "it has been stored and is equal to that returned"
    retrievedList == createdList
  }

  def "the service throws an exception if given invalid parameters for creation"() {

  }

}