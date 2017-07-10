package helpers

import java.io.FileInputStream
import java.util.*

object Prop {
    private lateinit var properties: Properties
    init {
        properties.load(FileInputStream("app.properties"))
    }

    public fun get(propString: String): String {
        return properties.getProperty(propString)
    }
}
