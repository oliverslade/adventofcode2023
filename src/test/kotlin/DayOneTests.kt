import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DayOneTests {

    private val dayOne = DayOne()

    @Test
    fun `an input string with no digits must output zero`() {
        assertEquals(0, dayOne.parseLine("abcdef"))
    }

    @Test
    fun `an empty input string must output zero`() {
        assertEquals(0, dayOne.parseLine(""))
    }

    @Test
    fun `an input string containing a single digit must output the digit twice`() {
        assertEquals(77, dayOne.parseLine("treb7uchet"))
    }

    @Test
    fun `an input string containing 2 digits must output the digits`() {
        assertEquals(12, dayOne.parseLine("1abc2"))
        assertEquals(38, dayOne.parseLine("pqr3stu8vwx"))
    }

    @Test
    fun `an input string containing many digits must output the first and last digit`() {
        assertEquals(15, dayOne.parseLine("a1b2c3d4e5f"))
    }

    @Test
    fun `sumCalibrationValues when given an empty list returns zero`() {
        assertEquals(0, dayOne.sumCalibrationValues(emptyList())) // Empty list
    }

    @Test
    fun `sumCalibrationValues when given a list with no digits returns zero`() {
        assertEquals(0, dayOne.sumCalibrationValues(listOf("abcdef"))) // List with no digits
    }

    @Test
    fun `sumCalibrationValues must calculate the sum of the parsed inputs`() {
        val calibrationValues = listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")
        assertEquals(142, dayOne.sumCalibrationValues(calibrationValues))
    }

    @Test
    fun `readValuesFromFile throws an exception when file path is incorrect`() {
        val invalidPath = "nonexistent/path/to/file.txt"

        val exception = assertThrows<IllegalArgumentException> {
            dayOne.readValuesFromFile(invalidPath)
        }

        assertTrue(exception.message!!.contains("File not found"))
    }
}
