import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayThreeTests {
    private val dayThree = DayThree()

    @Test
    fun `Adjacent value should be correctly extracted`() {
        val schematic = listOf("123456")
        val result = dayThree.getAdjacentValue(schematic, 0, 2)
        assertEquals(3456, result)
    }

    @Test
    fun `Adjacent value extraction should return null for non-digit characters`() {
        val schematic = listOf("*..")
        val result = dayThree.getAdjacentValue(schematic, 0, 0)
        assertEquals(null, result)
    }

}
