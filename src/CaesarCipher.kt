class CaesarCipher(private var input: String, shift: Int) {

    // Create a string containing the uppercase alphabet
    private val alphabet = ('A'..'Z').joinToString("")
    // Create a shifted version of the alphabet by taking
    // the last shift characters and moving them to the front
    private val shiftedAlphabet = alphabet.substring(shift) + alphabet.substring(0, shift)

    init {
        println("Alphabet: $alphabet")
        println("Shifted Alphabet: $shiftedAlphabet\n")
        println("Plain text: $input")
        println("Cipher text: ${getCipher()}")
    }

    private fun getCipher(): String {
        // Map each character in the input string to its shifted counterpart
        return input.map { char ->
            when {
                // If the character is an uppercase letter, find its index in the
                // alphabet and use it to look up the shifted character in the shifted alphabet
                char.isLetter() && char.isUpperCase() -> {
                    shiftedAlphabet[alphabet.indexOf(char)]
                }
                // If the character is a lowercase letter, find its index in the alphabet
                // (after converting it to uppercase) and use it to look up the shifted character in the
                // shifted alphabet (and convert it back to lowercase)
                char.isLetter() && char.isLowerCase() -> {
                    shiftedAlphabet[alphabet.indexOf(char.uppercaseChar())].lowercaseChar()
                }
                // If the character is not a letter, do not shift it
                else -> char
            }
        }.joinToString("")
    }
}