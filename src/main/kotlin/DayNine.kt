class DayNine {
    fun calculateSumOfNextValues(input: List<String>): Long {
        return input.sumOf { findNextValue(it) }
    }

    private fun findNextValue(line: String): Long {
        val values = line.split(" ").map { it.toLong() }.toLongArray()
        val extrapolatedValues = getNextValue(values)
        return extrapolatedValues.last()
    }

    private fun getNextValue(values: LongArray): LongArray {
        return if (values.all { it == 0L }) {
            values + 0L
        } else {
            val differences = LongArray(values.size - 1) { i -> values[i + 1] - values[i] }
            val subArray = getNextValue(differences)
            LongArray(values.size + 1) { i -> if (i < values.size) values[i] else values.last() + subArray.last() }
        }
    }
}
