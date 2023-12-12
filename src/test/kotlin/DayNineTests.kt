import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayNineTest {

    private val dayNine = DayNine()

    @Test
    fun `test calculateSumOfPreviousValues with single line`() {
        val input = listOf("10 15 20 25 30")
        val expected = 5L
        assertEquals(expected, dayNine.calculateSumOfPreviousValues(input))
    }

    @Test
    fun `test calculateSumOfPreviousValues with multiple lines`() {
        val input = listOf(
            "10 15 20 25 30",
            "5 10 15 20 25 30",
            "1 4 9 16 25"
        )
        val expected = 5L
        assertEquals(expected, dayNine.calculateSumOfPreviousValues(input))
    }

    @Test
    fun `test findPreviousValues with simple sequence`() {
        val values = listOf(10L, 15L, 20L, 25L, 30L)
        val expected = listOf(10L, 15L, 20L, 25L, 30L, 5L)
        assertEquals(expected, dayNine.findPreviousValues(values))
    }

    @Test
    fun `test findPreviousValues with complex sequence`() {
        val values = listOf(1L, 4L, 9L, 16L, 25L)
        val expected = listOf(1L, 4L, 9L, 16L, 25L, 0L)
        assertEquals(expected, dayNine.findPreviousValues(values))
    }
}
