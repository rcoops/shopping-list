package me.cooper.rick.shoppinglist.service.user

import spock.lang.Specification


class UserServiceSpec extends Specification {

  def userService

  def setup() {
    this.userService = new DummyUserService()
  }

  def "when creating a new user"() {

  }
}