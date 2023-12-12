import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayNineTest {

    private val dayNine = DayNine()

    @Test
    fun `calculate sum of next values for simple increasing sequence`() {
        val input = listOf("0 1 2 3 4")
        val expected = 5L
        assertEquals(expected, dayNine.calculateSumOfNextValues(input))
    }

    @Test
    fun `calculate sum of next values for complex sequence`() {
        val input = listOf("3 6 10 15 21")
        val expected = 28L
        assertEquals(expected, dayNine.calculateSumOfNextValues(input))
    }

    @Test
    fun `calculate sum of next values for constant sequence`() {
        val input = listOf("5 5 5 5")
        val expected = 5L
        assertEquals(expected, dayNine.calculateSumOfNextValues(input))
    }

    @Test
    fun `calculate sum of next values for decreasing sequence`() {
        val input = listOf("10 8 6 4 2")
        val expected = 0L
        assertEquals(expected, dayNine.calculateSumOfNextValues(input))
    }

    @Test
    fun `calculate sum of next values for mixed sequence`() {
        val input = listOf("1 4 9 16 25")
        val expected = 36L
        assertEquals(expected, dayNine.calculateSumOfNextValues(input))
    }
}
