package me.cooper.rick.shoppinglist.service

interface CRUDService<T, ID> {

    // C
    fun new(it: T): T?

    // R
    fun one(id: Long): T?
    fun some(vararg ids: ID): List<T>
    fun all(): List<T>

    // U
    fun change(id: ID, entity: T): T?

    // D
    fun remove(entity: T): Boolean
    fun removeById(id: ID): Boolean

    fun totalCount(): Int

}