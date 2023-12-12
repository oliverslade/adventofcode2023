import kotlin.math.abs

class DayEight {
    fun navigateAsGhost(input: List<String>): Long {
        val instructions = input.first()
        val nodes = input.drop(1)
            .filter { it.isNotBlank() }
            .associate { line ->
                val parts = line.split(" = ", ", ").map { it.trim(' ', '(', ')') }
                parts[0] to (parts[1] to parts[2])
            }

        val startingPoints = nodes.keys.filter { it.endsWith("A") }
        val results = startingPoints.map { startFromPoint(it, instructions, nodes) }

        return calculateLeastCommonMultiple(results)
    }

    fun startFromPoint(startPoint: String, instructions: String, nodes: Map<String, Pair<String, String>>): Long {
        var current = startPoint
        var steps = 0L

        while (current.isNotEmpty()) {
            steps++
            val direction = instructions[((steps - 1) % instructions.length).toInt()]
            current = getNextLocation(current, direction, nodes)

            if (current.endsWith("Z")) {
                return steps
            }
        }

        throw IllegalStateException("Failed to find a path ending in 'Z' from start point '$startPoint'")
    }

    private fun getNextLocation(current: String, direction: Char, nodes: Map<String, Pair<String, String>>): String {
        val nextNode = nodes[current]
        return if (nextNode != null) {
            if (direction == 'R') nextNode.second else nextNode.first
        } else {
            ""
        }
    }

    private fun calculateLeastCommonMultiple(numbers: List<Long>): Long {
        var result = leastCommonMultiple(numbers[0], numbers[1])
        for (i in 2..<numbers.size) {
            result = leastCommonMultiple(result, numbers[i])
        }
        return result
    }

    private fun leastCommonMultiple(a: Long, b: Long): Long {
        return if (a == 0L && b == 0L) 0 else abs(a) / greatestCommonDivisor(a, b) * abs(b)
    }

    private fun greatestCommonDivisor(a: Long, b: Long): Long {
        if (a == 0L) return b
        if (b == 0L) return a
        if (a == b) return a
        if (a % 2L == 0L) {
            return if (b % 2L != 0L) greatestCommonDivisor(a shr 1, b) else greatestCommonDivisor(a shr 1, b shr 1) shl 1
        }
        if (b % 2L == 0L) return greatestCommonDivisor(a, b shr 1)
        return if (a > b) greatestCommonDivisor((a - b) shr 1, b) else greatestCommonDivisor((b - a) shr 1, a)
    }
}
