package helpers

import java.io.FileInputStream
import java.util.*

object Prop {
    fun get(propString: String): String {
        val properties = Properties()
        FileInputStream("app.properties").use {
            properties.load(it)
        }
        return properties.getProperty(propString)
    }
}
