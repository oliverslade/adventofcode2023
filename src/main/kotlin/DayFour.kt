import java.io.File

class DayFour {
    fun calculateTotalCards(scratchcards: List<String>): Int {
        val copiesOfCards = mutableMapOf<Int, Int>()

        scratchcards.indices.forEach { index -> copiesOfCards[index] = 1 }

        scratchcards.forEachIndexed { index, card ->
            val (winningNumbers, cardNumbers) = parseCard(card)
            val matches = calculateMatches(winningNumbers, cardNumbers)

            for (j in 1..matches) {
                val nextCardIndex = index + j
                if (nextCardIndex < scratchcards.size) {
                    copiesOfCards[nextCardIndex] = copiesOfCards[nextCardIndex]!! + copiesOfCards[index]!!
                }
            }
        }

        return copiesOfCards.values.sum()
    }

    private fun parseCard(card: String): Pair<List<String>, List<String>> {
        val (winningNumbers, cardNumbers) = card.split(" | ").map {
            it.split(" ").filter { number -> number.isNotEmpty() }
        }
        return Pair(winningNumbers, cardNumbers)
    }

    private fun calculateMatches(winningNumbers: List<String>, cardNumbers: List<String>): Int {
        return winningNumbers.count { it in cardNumbers }
    }

    fun readScratchcardsFromFile(filePath: String): List<String> {
        return File(filePath).readLines().map { it.substringAfter(": ").trim() }
    }
}