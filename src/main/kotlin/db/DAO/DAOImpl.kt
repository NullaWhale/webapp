package db.DAO

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import java.io.Serializable


open class DAOImpl<T> {
    private val session: Session = getSessionFactory().openSession()

    fun getSessionFactory(): SessionFactory {
        return Configuration().configure().buildSessionFactory()
    }

    fun getSession(): Session {
        return session
    }

    fun save(t: T): Boolean {
        try {
            session.beginTransaction()
            session.save(t)
            session.transaction.commit()
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            return false
        }
    }

    fun delete(t: T): Boolean {
        try {
            session.delete(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            return false
        }
    }

    fun update(t: T): Boolean {
        try {
            session.update(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            return false
        }
    }

    fun find(clazz: Class<T>, id: Serializable): T? {
        return session.find(clazz, id)
    }

    fun uniqueResult(hql: String): T? {
        try {
            session.beginTransaction()
            val result: Any = session.createQuery(hql).uniqueResult()
            session.transaction.commit()
            return result as T?
        } catch (e: Exception) {
            session.transaction.rollback()
            return null
        }
    }
}