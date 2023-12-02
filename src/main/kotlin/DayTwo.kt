import java.io.File

class DayTwo {
    fun solve(input: List<String>): Int {
        return input.mapNotNull { parseGame(it) }
            .filter { isGamePossible(it.second) }
            .sumOf { it.first }
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

    private fun isGamePossible(combinations: List<CubeCombination>): Boolean {
        val maxCubes = CubeCombination(12, 13, 14)
        return combinations.all {
            it.red <= maxCubes.red && it.green <= maxCubes.green && it.blue <= maxCubes.blue
        }
    }

    fun readGamesFromFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}

data class CubeCombination(val red: Int, val green: Int, val blue: Int)
