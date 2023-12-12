import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayEightTests {

    private val dayEight = DayEight()

    @Test
    fun `navigate returns correct step count for example input 1`() {
        val input = listOf(
            "RL",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        val result = dayEight.navigate(input)
        assertEquals(2, result)
    }

    @Test
    fun `navigate returns correct step count for example input 2`() {
        val input = listOf(
            "LLR",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        val result = dayEight.navigate(input)
        assertEquals(6, result)
    }

}
