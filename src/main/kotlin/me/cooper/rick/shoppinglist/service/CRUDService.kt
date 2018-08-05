package me.cooper.rick.shoppinglist.service

interface CRUDService<T> {

    // C
    fun new(it: T): T?

    // R
    fun one(id: Long): T?
    fun some(vararg ids: Long): List<T>
    fun all(): List<T>

    // U
    fun change(entity: T): T?

    // D
    fun remove(entity: T): Boolean
    fun remove(id: Long): Boolean

}