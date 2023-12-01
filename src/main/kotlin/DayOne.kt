import java.io.File
import java.nio.file.Paths

class DayOne {

    private val digitMapping = mapOf(
        "zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4,
        "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
    ).plus((0..9).associateBy { it.toString() })

    fun parseLine(line: String): Int {
        val firstDigit = findFirstNum(line, false) ?: 0
        val lastDigit = findFirstNum(line.reversed(), true) ?: 0
        return firstDigit * 10 + lastDigit
    }

    private fun findFirstNum(line: String, reversed: Boolean): Int? {
        var bestMatch: Int? = null
        var bestIdx = line.length

        for ((key, value) in digitMapping) {
            val searchKey = if (reversed) key.reversed() else key
            val idx = line.indexOf(searchKey)
            if (idx in 0..<bestIdx) {
                bestIdx = idx
                bestMatch = value
            }
        }

        return bestMatch
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
