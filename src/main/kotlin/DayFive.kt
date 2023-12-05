class DayFive {
    fun findLowestLocation(seeds: List<Long>, mappings: Map<String, List<Triple<Long, Long, Long>>>): Long {
        var lowestLocation = Long.MAX_VALUE
        for (seed in seeds) {
            var location = seed
            location = convertNumber(location, mappings["seed-to-soil"]!!)
            location = convertNumber(location, mappings["soil-to-fertilizer"]!!)
            location = convertNumber(location, mappings["fertilizer-to-water"]!!)
            location = convertNumber(location, mappings["water-to-light"]!!)
            location = convertNumber(location, mappings["light-to-temperature"]!!)
            location = convertNumber(location, mappings["temperature-to-humidity"]!!)
            location = convertNumber(location, mappings["humidity-to-location"]!!)
            if (location < lowestLocation) {
                lowestLocation = location
            }
        }
        return lowestLocation
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
