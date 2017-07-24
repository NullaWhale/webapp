package util

import java.security.MessageDigest

fun md5(message: String): String {
    var res = ""
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(message.toByteArray())
    for (byte in digest) res += "%02x".format(byte)
    return res
}