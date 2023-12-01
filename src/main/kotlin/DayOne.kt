import java.io.File
import java.nio.file.Paths

class DayOne {

    fun parseLine(line: String): Int {
        val firstDigit = line.firstOrNull { it.isDigit() }?.toString()?.toInt() ?: 0
        val lastDigit = line.lastOrNull { it.isDigit() }?.toString()?.toInt() ?: 0
        return firstDigit * 10 + lastDigit
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
