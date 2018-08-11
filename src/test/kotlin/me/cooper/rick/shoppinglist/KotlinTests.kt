package me.cooper.rick.shoppinglist

import org.junit.Test

class KotlinTests {

    @Test
    fun mappingStuff() {
        val map = mutableMapOf<Long?, String>(1L to "something")
        val x = map[null]
        print(x)
    }

}
