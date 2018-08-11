package me.cooper.rick.shoppinglist.service.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingList
import spock.lang.Specification
import spock.lang.Unroll

import static me.cooper.rick.shoppinglist.FixturesKt.TEST_USER_1
import static me.cooper.rick.shoppinglist.FixturesKt.TEST_USER_2

class ShoppingListCRUDServiceSpec extends Specification {

  private static final String NAME = "My List"
  private static final String OTHER_NAME = "My Other List"

  private static ShoppingListCRUDService shoppingListService

  def setup() {
    shoppingListService = new InMemoryShoppingListCRUDService()
  }

  def "new shopping list from object"() {
    given: "a potential shopping list to be created"
    def listToCreate = new ShoppingList(NAME, TEST_USER_1)
    def secondListToCreate = new ShoppingList(OTHER_NAME, TEST_USER_2)
    and: "there are no stored lists"
    shoppingListService.totalCount() == 0

    when: "the service is called to create a new list"
    def createdList = shoppingListService.new(listToCreate)

    then: "the returned list has an id"
    createdList.id
    and: "the returned list has the given parameters"
    createdList.name == NAME
    createdList.users == [TEST_USER_1].toSet()
    and: "the service has stored the list"
    shoppingListService.totalCount() == 1

    when: "the service is called to create a new list"
    def secondCreatedList = shoppingListService.new(secondListToCreate)

    then: "the returned list has an id"
    secondCreatedList.id
    and: "the returned list has the given parameters"
    secondCreatedList.name == OTHER_NAME
    secondCreatedList.users == [TEST_USER_2].toSet()
    and: "the service has stored the list"
    shoppingListService.totalCount() == 2

    when: "the lists are then retrieved from the service"
    def retrievedList = shoppingListService.one(createdList.id)
    def secondRetrievedList = shoppingListService.one(secondCreatedList.id)

    then: "it has been stored and is equal to that returned"
    retrievedList == createdList
    secondRetrievedList == secondCreatedList
    retrievedList != secondRetrievedList
  }

  @Unroll
  def "new shopping list from {#name} and user, stripping name whitespace"() {
    when: "the service is called to create a new list"
    def createdList = shoppingListService.new(NAME, TEST_USER_1)

    then: "the returned list has an id"
    createdList.id
    and: "the name of the returned list is the same as that passed"
    createdList.name == NAME
    and: "the returned list has a set containing the given user and no other"
    createdList.users == [TEST_USER_1].toSet()

    when: "the list is then retrieved from the service"
    def retrievedList = shoppingListService.one(createdList.id)
    then: "it has been stored and is equal to that returned"
    retrievedList == createdList

    where: "name is provided either with or without spaces"
    name << [NAME, "   $NAME", "$NAME  ", " $NAME "]
  }

  @Unroll
  def "new user with blank name returns null"() {
    when: "the service is asked to create and store a list"
    def shoppingList = shoppingListService.new(name, TEST_USER_1)

    then: "no list is returned"
    !shoppingList
    and:
    shoppingListService.totalCount() == 0

    where: "an empty or space only name is supplied"
    name << ["", " ", "                  "]
  }

  def "retrieval of un-stored shopping list returns null"() {
    when:
    def shoppingList = shoppingListService.one(999L)

    then:
    !shoppingList
  }

  @Unroll
  def "add item to list"() {

    where:
    shoppingList |
  }

}