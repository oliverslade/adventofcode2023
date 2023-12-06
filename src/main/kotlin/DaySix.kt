import java.io.File

class DaySix {

    fun readRacesFromFile(filePath: String): List<Pair<Int, Int>> {
        val file = File(filePath)
        val lines = file.readLines()
        val times = lines[0].substringAfter("Time:").trim().split("\\s+".toRegex()).map { it.toInt() }
        val distances = lines[1].substringAfter("Distance:").trim().split("\\s+".toRegex()).map { it.toInt() }

        return times.zip(distances)
    }

    fun calculateWaysToWin(races: List<Pair<Int, Int>>): Long {
        return races.map { (time, distance) -> calculateWaysForSingleRace(time, distance) }.reduce { acc, ways -> acc * ways }
    }

    private fun calculateWaysForSingleRace(time: Int, record: Int): Long {
        var waysToWin = 0L
        for (holdTime in 0..<time) {
            val distance = holdTime * (time - holdTime)
            if (distance > record) waysToWin++
        }
        return waysToWin
    }
}
