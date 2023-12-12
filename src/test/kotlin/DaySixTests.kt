import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DaySixTests {

    private val daySix = DaySix()

    @Test
    fun `Calculate ways to win for a short race`() {
        val time = 7L
        val distance = 9L
        val expectedWays = 4L

        val result = daySix.calculateWaysToWinSingleRace(time, distance)
        assertEquals(expectedWays, result)
    }

    @Test
    fun `Calculate ways to win for a longer race`() {
        val time = 71530L
        val distance = 940200L
        val expectedWays = 71503L

        val result = daySix.calculateWaysToWinSingleRace(time, distance)
        assertEquals(expectedWays, result)
    }

    @Test
    fun `Calculate ways to win for a race with no possible wins`() {
        val time = 5L
        val distance = 100L
        val expectedWays = 0L

        val result = daySix.calculateWaysToWinSingleRace(time, distance)
        assertEquals(expectedWays, result)
    }
}
