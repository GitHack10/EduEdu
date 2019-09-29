package ru.rzd.eduedu.domain.global.models

class User(val userInfo: UserInfo? = null) {

    inner class UserInfo(
        val name: String,
        val birth: String,
        val gender: Int
    )
}