import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFourTests {
    private val dayFour = DayFour()

    @Test
    fun `should return zero points for a scratchcard with no matches`() {
        val scratchcard = "1 2 3 4 5 | 6 7 8 9 10"
        val totalPoints = dayFour.calculateTotalPoints(listOf(scratchcard))
        assertEquals(0, totalPoints)
    }

    @Test
    fun `should calculate total points correctly for a single scratchcard with multiple matches`() {
        val scratchcard = "1 2 3 4 5 | 1 2 3 4 5"
        val totalPoints = dayFour.calculateTotalPoints(listOf(scratchcard))
        assertEquals(16, totalPoints)
    }

}