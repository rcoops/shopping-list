package me.cooper.rick.shoppinglist

import me.cooper.rick.shoppinglist.service.shoppinglist.InMemoryShoppingListService
import org.junit.Test

class KotlinTests {

    @Test
    fun mappingStuff() {
        val map = mutableMapOf<Long?, String>(1L to "something")
        val x = map[null]
        print(x)
    }

}
