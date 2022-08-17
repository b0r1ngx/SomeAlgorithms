object Wordle {
    // Mind 'throw upped' to realisation in bad at O(n)
    fun bestWhatIveGot(word: String, guess : String): String {
        val wordSize = word.length
        val wordEntries = IntArray(26)
        val guessEntries = List(26) { mutableListOf<Int>() }

        val answer = CharArray(wordSize) { '.' }

        for (i in 0 until wordSize) {
            val wordChar = word[i]
            val guessChar = guess[i]

            if (wordChar == guessChar)
                answer[i] = 'G'
            else {
                if (guessEntries[wordChar - 'A'].isNotEmpty()) {
                    val j = guessEntries[wordChar - 'A'].removeFirst()
                    answer[j] = 'Y'
                } else
                    wordEntries[wordChar - 'A']++


                if (wordEntries[guessChar - 'A'] > 0) {
                    wordEntries[guessChar - 'A']--
                    answer[i] = 'Y'
                } else
                    guessEntries[guessChar - 'A'].add(i)
            }
        }
        return String(answer)
    }

    // Asymptotic: Speed - O(2*n), Memory - O(n)?7
    fun someOtherView(word: String, guess: String): String {
        val answer = CharArray(word.length) { '.' }
        val counts = IntArray(26)

        for (i in word.indices)
            if (word[i] == guess[i])
                answer[i] = 'G'
            else
                counts[word[i] - 'A']++

        for (i in word.indices)
            if (word[i] != guess[i] && counts[guess[i] - 'A']-- > 0)
                answer[i] = 'Y'

        return String(answer)
    }
}

fun main() {
    val s = readLine()!!
    val t = readLine()!!
    print(Wordle.bestWhatIveGot(s, t))
}