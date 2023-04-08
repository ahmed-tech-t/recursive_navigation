package com.example.recursivenavigation.util
import org.bouncycastle.jcajce.provider.digest.SHA3
import org.bouncycastle.util.encoders.Hex

object SHA {
    fun ByteArray.sha3_256(): ByteArray {
        val digest = SHA3.Digest256()
        return digest.digest(this)
    }

    fun ByteArray.toHexString(): String {
        return Hex.toHexString(this)
    }
}