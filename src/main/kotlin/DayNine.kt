class DayNine {

    fun calculateSumOfPreviousValues(input: List<String>): Long {
        return input.sumOf {
            val values = it.split(" ").map(String::toLong)
            findPreviousValues(values).last()
        }
    }

    fun findPreviousValues(values: List<Long>): List<Long> {
        return if (values.all { it == 0L }) {
            listOf(values.first())
        } else {
            val subArray = findPreviousValues(values.calculateDifferences())
            val newValues = values.toMutableList()
            newValues.add(values.first() - subArray.last())
            newValues.toList()
        }
    }

    private fun List<Long>.calculateDifferences(): List<Long> {
        return if (size <= 1) listOf(0) else this.zipWithNext { a, b -> b - a }
    }
}
