class DayFive {

    fun findLowestLocation(seedRanges: List<Pair<Long, Long>>, mappings: Map<String, List<Triple<Long, Long, Long>>>): Long {
        var lowestLocation = Long.MAX_VALUE

        for ((seedStart, rangeLength) in seedRanges) {
            for (offset in 0..<rangeLength) {
                val seed = seedStart + offset
                var location = convertThroughMappings(seed, mappings)

                if (location < lowestLocation) {
                    lowestLocation = location
                }
            }
        }

        return lowestLocation
    }

    private fun convertThroughMappings(number: Long, mappings: Map<String, List<Triple<Long, Long, Long>>>): Long {
        var currentNumber = number
        for (mapping in mappings.values) {
            currentNumber = convertNumber(currentNumber, mapping)
        }
        return currentNumber
    }

    private fun convertNumber(number: Long, mapping: List<Triple<Long, Long, Long>>): Long {
        for ((destStart, srcStart, range) in mapping) {
            if (number in srcStart..<(srcStart + range)) {
                return destStart + (number - srcStart)
            }
        }
        return number
    }

    fun parseAlmanac(almanac: String): Map<String, List<Triple<Long, Long, Long>>> {
        val mappings = mutableMapOf<String, List<Triple<Long, Long, Long>>>()
        val sections = almanac.split("\n\n")
        for (section in sections) {
            val lines = section.trim().split("\n")
            val title = lines.first().removeSuffix(" map:").trim()
            val map = lines.drop(1).map {
                val (destStart, srcStart, range) = it.split(" ").map(String::toLong)
                Triple(destStart, srcStart, range)
            }
            mappings[title] = map
        }
        return mappings
    }
}
