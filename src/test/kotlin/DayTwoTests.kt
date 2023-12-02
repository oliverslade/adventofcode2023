import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayTwoTests {
    private val dayTwo = DayTwo()

    @Test
    fun `Minimum cube set for a single game should match expected values`() {
        val input = listOf("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        val result = dayTwo.solve(input)
        assertEquals(48, result)
    }

    @Test
    fun `Minimum cube set for multiple games should return correct sum of powers`() {
        val input = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
        val result = dayTwo.solve(input)
        assertEquals(2286, result) // Sum of powers as per the problem statement
    }

    @Test
    fun `Game with varying numbers of cube colors should calculate power correctly`() {
        val input = listOf("Game 6: 2 red, 3 green; 1 blue, 1 red")
        val result = dayTwo.solve(input)
        assertEquals(6, result) // 2 red * 3 green * 1 blue = 6
    }

    @Test
    fun `Empty input list should return zero`() {
        val input = listOf<String>()
        val result = dayTwo.solve(input)
        assertEquals(0, result)
    }
}
