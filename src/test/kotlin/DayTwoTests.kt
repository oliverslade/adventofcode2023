import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayTwoTests {
    private val dayTwo = DayTwo()

    @Test
    fun `Empty input list must return zero`() {
        val input = listOf<String>()
        val result = dayTwo.solve(input)
        assertEquals(0, result)
    }

    @Test
    fun `Game with all cubes within limits must return game ID`() {
        val input = listOf("Game 6: 1 red, 2 green, 3 blue; 2 red, 3 green, 4 blue")
        val result = dayTwo.solve(input)
        assertEquals(6, result)
    }

    @Test
    fun `Game with one combination exceeding limits must return zero`() {
        val input = listOf("Game 7: 5 red, 8 green; 13 blue, 15 red; 1 green, 2 blue")
        val result = dayTwo.solve(input)
        assertEquals(0, result)
    }

    @Test
    fun `Game with varying numbers of cube colors must return correct ID`() {
        val input = listOf("Game 8: 1 red; 2 green; 3 blue")
        val result = dayTwo.solve(input)
        assertEquals(8, result)
    }

    @Test
    fun `Game is possible within cube limits must return the game ID`() {
        val input = listOf("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        val result = dayTwo.solve(input)
        assertEquals(1, result)
    }

    @Test
    fun `Game is impossible with too many cubes of one color must return zero`() {
        val input = listOf("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")
        val result = dayTwo.solve(input)
        assertEquals(0, result)
    }

    @Test
    fun `Game is impossible with too many cubes of multiple colors must return zero`() {
        val input = listOf("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")
        val result = dayTwo.solve(input)
        assertEquals(0, result)
    }

    @Test
    fun `Multiple games mixed with possible and impossible scenarios must return sum of IDs of possible games`() {
        val input = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
        val result = dayTwo.solve(input)
        assertEquals(6, result)
    }

}
