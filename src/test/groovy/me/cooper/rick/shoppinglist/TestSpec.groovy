package me.cooper.rick.shoppinglist

import me.cooper.rick.shoppinglist.domain.ShoppingItem
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Just making sure spock will work with Kotlin
 */
class TestSpec extends Specification {

  @Unroll
  def "#x + 3 = #answer"() {
    given: "1 = 1"
    def y = 2

    when: "adding 2"
    def z = x + y

    then: "y = 3"
    z == answer

    where: "x is a bunch of things"
    x || answer
    1 || 3
    2 || 4
    3 || 5
  }

  @Unroll
  def "shopping item with name #name"() {
    when: "a new shopping item is created"
    def shoppingItem = new ShoppingItem(name)

    then: "wgw"
    shoppingItem.label == name

    where:
    name << ["something", "somethingelse"]
  }
}