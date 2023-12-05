import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DayFiveTests {

    private val dayFive = DayFive()

    @Test
    fun `findLowestLocation with basic scenario`() {
        val seedRanges = listOf(Pair(79L, 14L), Pair(55L, 13L))
        val mappings = mapOf(
            "seed-to-soil" to listOf(Triple(50L, 98L, 2L), Triple(52L, 50L, 48L)),
            "soil-to-fertilizer" to listOf(Triple(0L, 15L, 37L), Triple(37L, 52L, 2L), Triple(39L, 0L, 15L)),
            "fertilizer-to-water" to listOf(Triple(49L, 53L, 8L), Triple(0L, 11L, 42L), Triple(42L, 0L, 7L), Triple(57L, 7L, 4L)),
            "water-to-light" to listOf(Triple(88L, 18L, 7L), Triple(18L, 25L, 70L)),
            "light-to-temperature" to listOf(Triple(45L, 77L, 23L), Triple(81L, 45L, 19L), Triple(68L, 64L, 13L)),
            "temperature-to-humidity" to listOf(Triple(0L, 69L, 1L), Triple(1L, 0L, 69L)),
            "humidity-to-location" to listOf(Triple(60L, 56L, 37L), Triple(56L, 93L, 4L))
        )

        val result = dayFive.findLowestLocation(seedRanges, mappings)
        assertEquals(46L, result)
    }


    @Test
    fun `parseAlmanac with correct parsing`() {
        val almanac = """
            seed-to-soil map:
            50 98 2
            52 50 48
            
            soil-to-fertilizer map:
            0 15 37
        """.trimIndent()

        val result = dayFive.parseAlmanac(almanac)
        assertTrue("seed-to-soil" in result)
        assertTrue("soil-to-fertilizer" in result)
    }

    @Test
    fun `parseAlmanac with missing sections`() {
        val almanac = "seed-to-soil map:\n50 98 2"

        val result = dayFive.parseAlmanac(almanac)
        assertEquals(1, result.size)
        assertTrue("seed-to-soil" in result)
    }
}
