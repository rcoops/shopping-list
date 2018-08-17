package me.cooper.rick.shoppinglist.service.user

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.service.crud.CRUDService

interface UserService: CRUDService<AppUser, Long?> {

    fun addFriend(user: AppUser, friend: AppUser)
}