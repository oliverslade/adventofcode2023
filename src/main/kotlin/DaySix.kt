import java.io.File

class DaySix {

    fun calculateWaysToWinSingleRaceFromFile(filePath: String): Long {
        val lines = File(filePath).readLines()
        val (time, distance) = lines.map { it.filter { char -> char.isDigit() }.toLong() }
        return calculateWaysToWinSingleRace(time, distance)
    }

    internal fun calculateWaysToWinSingleRace(time: Long, distance: Long): Long {
        var waysToWin = 0L
        for (buttonTime in 1..<time) {
            val travelTime = time - buttonTime
            val traveledDistance = buttonTime * travelTime
            if (traveledDistance > distance) {
                waysToWin++
            }
        }
        return waysToWin
    }
}
