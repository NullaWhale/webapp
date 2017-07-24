package db.DAO

import db.models.User

interface UserDAO{
    fun createUser(login: String, password: String): Boolean
    fun getUserById(id: Int): User?
    fun getUserByName(login: String): User?
}