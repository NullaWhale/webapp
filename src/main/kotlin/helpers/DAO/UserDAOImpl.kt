package helpers.DAO

import models.User

class UserDAOImpl: DAOImpl<User>(), UserDAO {

    override fun createUser(login: String, password: String): Boolean {
        val user = User()
        user.login = login
        user.password = password
        return save(user)
    }

    override fun getUserById(id: Int): User? {
        return find(User::class.java, id)
    }

    override fun getUserByName(login: String): User? {
        return uniqueResult("from User where login = '$login'")
    }

}