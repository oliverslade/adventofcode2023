import java.io.File

class DayTwo {
    fun solve(input: List<String>): Int {
        return input.mapNotNull { parseGame(it) }
            .map { calculateMinimumCubes(it.second) }
            .sumOf { it.red * it.green * it.blue }
    }

    private fun parseGame(line: String): Pair<Int, List<CubeCombination>>? {
        val parts = line.split(": ")
        val gameId = parts[0].removePrefix("Game ").toInt()
        val combinations = parts[1].split("; ")
            .map { parseCombination(it.trim()) }

        return Pair(gameId, combinations)
    }

    private fun parseCombination(combination: String): CubeCombination {
        val counts = mapOf("red" to 0, "green" to 0, "blue" to 0).toMutableMap()

        combination.split(", ").forEach {
            val (count, color) = it.split(" ")
            counts[color] = counts[color]!! + count.toInt()
        }

        return CubeCombination(counts["red"]!!, counts["green"]!!, counts["blue"]!!)
    }

    private fun calculateMinimumCubes(combinations: List<CubeCombination>): CubeCombination {
        val maxRed = combinations.maxOfOrNull { it.red } ?: 0
        val maxGreen = combinations.maxOfOrNull { it.green } ?: 0
        val maxBlue = combinations.maxOfOrNull { it.blue } ?: 0

        return CubeCombination(maxRed, maxGreen, maxBlue)
    }

    fun readGamesFromFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}

data class CubeCombination(val red: Int, val green: Int, val blue: Int)
