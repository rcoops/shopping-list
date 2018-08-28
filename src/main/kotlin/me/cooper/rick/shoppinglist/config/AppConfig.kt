package me.cooper.rick.shoppinglist.config

import me.cooper.rick.shoppinglist.service.shoppinglist.DummyShoppingListService
import me.cooper.rick.shoppinglist.service.shoppinglist.JpaShoppingListService
import me.cooper.rick.shoppinglist.service.shoppinglist.ShoppingListService
import me.cooper.rick.shoppinglist.service.user.DummyUserService
import me.cooper.rick.shoppinglist.service.user.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class AppConfig {

  @Bean
//  @Profile("!database-enabled")
  fun dummyUserService(): UserService = DummyUserService()

  @Bean
  @Profile("!database-enabled")
  fun dummyShoppingListService(): ShoppingListService = DummyShoppingListService()

  /* DB */

  @Bean
  @Profile("database-enabled")
  fun jpaShoppingListService(): ShoppingListService = JpaShoppingListService()

}