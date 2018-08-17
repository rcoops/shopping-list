package me.cooper.rick.shoppinglist.service.crud

interface CRUDService<T, ID> {

    // C
    fun new(entity: T): T

    // R
    fun one(id: Long): T?
    fun some(vararg ids: ID): List<T>
    fun all(): List<T>

    // U
    fun change(entity: T): T

    // D
    fun remove(entity: T)
    fun removeById(id: ID)

    fun totalCount(): Long

}