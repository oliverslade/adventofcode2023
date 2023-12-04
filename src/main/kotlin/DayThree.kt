import java.io.File

class DayThree {
    fun calculateTotalGearRatios(schematic: List<String>): Int {
        var totalGearRatio = 0

        for (y in schematic.indices) {
            for (x in schematic[y].indices) {
                if (schematic[y][x] == '*') {
                    val gearRatio = calculateGearRatioAt(schematic, y, x)
                    if (gearRatio != null) {
                        totalGearRatio += gearRatio
                    }
                }
            }
        }

        return totalGearRatio
    }

    fun calculateGearRatioAt(schematic: List<String>, y: Int, x: Int): Int? {
        val partNumbers = mutableListOf<Int>()
        val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        for ((dx, dy) in directions) {
            val adjacentValue = getAdjacentValue(schematic, y + dy, x + dx)
            if (adjacentValue != null) partNumbers.add(adjacentValue)
        }

        return if (partNumbers.size == 2) partNumbers[0] * partNumbers[1] else null
    }

    fun getAdjacentValue(schematic: List<String>, y: Int, x: Int): Int? {
        if (y !in schematic.indices || x !in schematic[y].indices) return null
        if (schematic[y][x].isDigit()) {
            var end = x
            while (end < schematic[y].length && schematic[y][end].isDigit()) {
                end++
            }
            return schematic[y].substring(x, end).toInt()
        }
        return null
    }

    fun readSchematicFromFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}