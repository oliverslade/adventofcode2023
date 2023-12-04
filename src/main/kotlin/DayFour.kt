import java.io.File

class DayFour {
    fun calculateTotalPoints(scratchcards: List<String>): Int {
        return scratchcards.sumOf { calculatePointsForCard(it) }
    }

    fun readScratchcardsFromFile(filePath: String): List<String> {
        return File(filePath).readLines().map { it.substringAfter(": ").trim() }
    }

    private fun calculatePointsForCard(card: String): Int {
        val (winningNumbers, yourNumbers) = card.split(" | ").map {
            it.split(" ").filter { number -> number.isNotEmpty() }.map(String::toInt)
        }
        val matches = yourNumbers.count { it in winningNumbers }

        return if (matches > 0) 1.shl(matches - 1) else 0
    }
}