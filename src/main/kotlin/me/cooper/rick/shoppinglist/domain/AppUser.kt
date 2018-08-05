package me.cooper.rick.shoppinglist.domain

data class AppUser(val id: Long? = null,
                   val username: String,
                   val password: String,
                   val displayName: String,
                   val email: String? = null,
                   val friends: Set<AppUser> = emptySet(),
                   val shoppingLists: Set<ShoppingList> = emptySet())