fun main() {
    // Get caesar cipher of hello using 5 shifts
    CaesarCipher("Hello", 5)
    println()

    // Get MD5 hash of "Hello"
    MD5().getHash("Hello")
    println()

    // Get the hash of the list provided and check for collisions
    val strings = listOf("hello", "world", "foo", "bar")
    MD5().hasCollision(strings)
}