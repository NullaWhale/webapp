package db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

object PSQL {
    private val URL: String = "jdbc:postgresql://localhost:5432/test"
    private val USERNAME: String = "sysdba"
    private val PASSWORD: String = ""

    private lateinit var connection: Connection
    var isConnected = false

    fun connect() {
        if (isConnected) return
        Class.forName("org.postgresql.Driver")
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
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