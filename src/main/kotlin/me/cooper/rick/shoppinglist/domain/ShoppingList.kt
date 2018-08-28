package me.cooper.rick.shoppinglist.domain

import javax.persistence.Entity

@Entity
data class ShoppingList(val name: String,
                        val users: Set<AppUser>,
                        val id: Long? = null,
                        val items: List<ShoppingListItem> = emptyList()) {

    constructor(name: String, user: AppUser): this(name, setOf(user))

}
