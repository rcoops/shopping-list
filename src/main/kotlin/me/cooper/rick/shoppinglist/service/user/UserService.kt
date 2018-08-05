package me.cooper.rick.shoppinglist.service.user

import me.cooper.rick.shoppinglist.domain.AppUser
import me.cooper.rick.shoppinglist.service.CRUDService

interface UserService: CRUDService<AppUser> {

    fun addFriend(user: AppUser, friend: AppUser)
}