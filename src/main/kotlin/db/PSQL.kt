package db

import helpers.Prop
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

object PSQL {

    private lateinit var connection: Connection
    var isConnected = false

    fun connect() {
        if (isConnected) return
        Class.forName(Prop.get("database.className"))
        connection = DriverManager.getConnection(
            Prop.get("database.url"),
            Prop.get("database.login"),
            Prop.get("database.password")
        )
        connection.autoCommit = false
        print("connected")
    }

    fun doSelect(query: String): ResultSet? {
        val statement = connection.createStatement()
        return statement.executeQuery(query)
    }

    fun doInsert(query: String) {
        val statement = connection.createStatement()
        statement.executeUpdate(query)
        statement.close()
        connection.commit()
    }

    fun disconnect() {
        if (!connection.isClosed) {
            connection.close()
            print("disconnected")

        }
    }
}