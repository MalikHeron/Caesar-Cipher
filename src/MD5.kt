import java.math.BigInteger
import java.security.MessageDigest

class MD5 {

    fun getHash(input: String): String {
        // Get an instance of the MD5 MessageDigest
        val md = MessageDigest.getInstance("MD5")

        // Compute the MD5 hash of the input string (converted to a byte array)
        val digest = md.digest(input.toByteArray())

        // Convert the MD5 hash (a byte array) to a BigInteger
        val bigInt = BigInteger(1, digest)

        // Convert the BigInteger to a hexadecimal string and pad it with zeros
        // to ensure it has a length of 32 characters
        val hash = bigInt.toString(16).padStart(32, '0')
        println("Hash value of '$input': $hash")
        return hash
    }

    fun hasCollision(strings: List<String>) {
        // Compute the MD5 hash of each string in the input list
        val hashes = strings.map { input ->
            getHash(input)
        }

        // Check if the list of hashes contains any duplicates by comparing its size
        // to the size of the list with duplicates removed
        if (hashes.size != hashes.distinct().size)
            println("The list of strings has a collision.")
        else
            println("The list of strings has no collision.")
    }
}