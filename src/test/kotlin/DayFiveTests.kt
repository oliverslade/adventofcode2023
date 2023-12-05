import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DayFiveTests {

    private val dayFive = DayFive()

    @Test
    fun `findLowestLocation with basic scenario`() {
        val seeds = listOf(79L, 14L, 55L, 13L)
        val mappings = mapOf(
            "seed-to-soil" to listOf(
                Triple(50L, 98L, 2L),
                Triple(52L, 50L, 48L)
            ),
            "soil-to-fertilizer" to listOf(
                Triple(0L, 0L, 50L),
                Triple(52L, 50L, 48L)
            ),
            "fertilizer-to-water" to listOf(
                Triple(0L, 0L, 52L),
                Triple(53L, 52L, 48L)
            ),
            "water-to-light" to listOf(
                Triple(0L, 0L, 53L),
                Triple(54L, 53L, 47L)
            ),
            "light-to-temperature" to listOf(
                Triple(0L, 0L, 54L),
                Triple(55L, 54L, 46L)
            ),
            "temperature-to-humidity" to listOf(
                Triple(0L, 0L, 55L),
                Triple(56L, 55L, 45L)
            ),
            "humidity-to-location" to listOf(
                Triple(60L, 56L, 37L)
            )
        )

        val result = dayFive.findLowestLocation(seeds, mappings)
        assertEquals(13L, result)
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
