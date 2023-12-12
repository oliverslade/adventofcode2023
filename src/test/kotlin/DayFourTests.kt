import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFourTests {
    private val dayFour = DayFour()

    @Test
    fun `No matches should result in original count`() {
        val scratchcards = listOf("1 2 3 | 4 5 6", "4 5 6 | 7 8 9")
        assertEquals(2, dayFour.calculateTotalCards(scratchcards))
    }

    @Test
    fun `Some matches should result in correct total`() {
        val scratchcards = listOf("1 2 3 | 1 2 3", "4 5 6 | 1 2 3")
        assertEquals(3, dayFour.calculateTotalCards(scratchcards))
    }

    @Test
    fun `Single card should be counted once`() {
        val scratchcards = listOf("1 2 3 | 4 5 6")
        assertEquals(1, dayFour.calculateTotalCards(scratchcards))
    }

    @Test
    fun `Empty input should result in zero`() {
        val scratchcards = listOf<String>()
        assertEquals(0, dayFour.calculateTotalCards(scratchcards))
    }
}
