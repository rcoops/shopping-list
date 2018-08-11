package me.cooper.rick.shoppinglist.domain

import spock.lang.Specification

import static me.cooper.rick.shoppinglist.FixturesKt.TEST_USER_1

class ShoppingListSpec extends Specification {

  def "produces same result with different constructors"() {
    given: "A potential shopping list name"
    def name = "test"

    when: "creating lists with this name and the same user"
    def defaultList = new ShoppingList(name, [TEST_USER_1].toSet(), null, [])
    def secondaryList = new ShoppingList(name, TEST_USER_1)

    then: "they are the 'equal'"
    defaultList == secondaryList
  }

}