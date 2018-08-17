package me.cooper.rick.shoppinglist.service.user

import me.cooper.rick.shoppinglist.domain.AppUser
import org.springframework.stereotype.Service

@Service
@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class InMemoryUserService: UserService {

    override fun addFriend(user: AppUser, friend: AppUser) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun new(entity: AppUser): AppUser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun one(id: Long): AppUser? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun some(vararg ids: Long?): List<AppUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun all(): List<AppUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun change(user: AppUser): AppUser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(user: AppUser) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeById(id: Long?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun totalCount(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}