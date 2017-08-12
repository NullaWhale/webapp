package models

import java.io.Serializable
import javax.persistence.*

private const val TABLE_NAME = "t_users"

@Entity
@Table(name = TABLE_NAME)
public class User(): Serializable {
    public var id: Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        get

    public var login: String = ""
        @Column(name = "login", unique = true, nullable = false, length = 32)
        get
        set

    public var password: String = ""
        @Column(name = "password", unique = false, nullable = false, length = 32)
        get
        set

    override public fun toString(): String {
        return "User [id=$id, name=$login, password=$password]"
    }
}