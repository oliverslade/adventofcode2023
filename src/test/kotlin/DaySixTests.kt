import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DaySixTest {

    private val daySix = DaySix()

    @Test
    fun `calculateWaysToWin with basic scenario`() {
        val races = listOf(
            Pair(7, 9),
            Pair(15, 40),
            Pair(30, 200)
        )
        val result = daySix.calculateWaysToWin(races)
        assertEquals(288L, result)
    }

    @Test
    fun `calculateWaysToWin with single race`() {
        val races = listOf(Pair(56, 334))
        val result = daySix.calculateWaysToWin(races)
        val expectedResult = 43L
            assertEquals(expectedResult, result)
    }

    @Test
    fun `calculateWaysToWin with multiple races`() {
        val races = listOf(
            Pair(56, 334),
            Pair(71, 1135),
            Pair(79, 1350),
            Pair(99, 2430)
        )
        val result = daySix.calculateWaysToWin(races)
        val expectedResult = 211904L
            assertEquals(expectedResult, result)
    }
}
