package util

import db.DAO.UserDAO
import db.DAO.UserDAOImpl
import db.models.User

object UserManager {

    fun login(login: String, password: String): Int {
        val userDAO: UserDAO = UserDAOImpl()

        val user: User? = userDAO.getUserByName(login)
        if (user != null) {
            if (md5(password) == user.password) {
                return 0
            } else {
                return -1
            }
        } else {
            userDAO.createUser(login, md5(password))
            return 1
        }
    }
}