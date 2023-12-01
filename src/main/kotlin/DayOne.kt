import java.io.File
import java.nio.file.Paths

class DayOne {

    private val digitMap = mapOf(
        "one" to 1, "two" to 2, "three" to 3, "four" to 4,
        "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
    )

    fun parseLine(line: String): Int {
        val digits = extractDigits(line)
        val firstDigit = digits.firstOrNull() ?: 0
        val lastDigit = digits.lastOrNull() ?: 0
        return firstDigit * 10 + lastDigit
    }

    fun extractDigits(line: String): List<Int> {
        val regex = Regex("one|two|three|four|five|six|seven|eight|nine|\\d")
        return regex.findAll(line).mapNotNull { match ->
            digitMap[match.value] ?: match.value.toIntOrNull()
        }.toList()
    }

    fun sumCalibrationValues(input: List<String>): Int {
        return input.sumOf { parseLine(it) }
    }

    fun readValuesFromFile(filePath: String): List<String> {
        val path = Paths.get(filePath)
        if (!path.toFile().exists()) {
            throw IllegalArgumentException("File not found: $filePath")
        }
        return File(filePath).readLines()
    }
}
