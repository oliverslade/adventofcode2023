import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayEightTests {

    private val dayEight = DayEight()

    @Test
    fun `navigateAsGhost with simple input`() {
        val input = listOf(
            "LR",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)"
        )

        val result = dayEight.navigateAsGhost(input)
        assertEquals(6, result)
    }

    @Test
    fun `startFromPoint with specific path`() {
        val nodes = mapOf(
            "AAA" to ("BBB" to "CCC"),
            "BBB" to ("DDD" to "EEE"),
            "CCC" to ("ZZZ" to "GGG"),
            "DDD" to ("DDD" to "DDD"),
            "EEE" to ("EEE" to "EEE"),
            "GGG" to ("GGG" to "GGG"),
            "ZZZ" to ("ZZZ" to "ZZZ")
        )
        val instructions = "RL"

        val result = dayEight.startFromPoint("AAA", instructions, nodes)
        assertEquals(2, result)
    }
}
