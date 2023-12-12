class DayEight {

    fun navigate(input: List<String>): Long {
        val rlSequence = input.first()
        var currentLocation = "AAA"
        var stepCount = 0L

        while (currentLocation != "ZZZ") {
            val instructionLine = input.findInstructionLine(currentLocation)
            currentLocation = instructionLine.getNextLocation(rlSequence, stepCount)
            stepCount++
        }

        return stepCount
    }

    private fun List<String>.findInstructionLine(location: String): String =
        first { it.startsWith(location) }

    private fun String.getNextLocation(rlSequence: String, stepCount: Long): String =
        if (rlSequence[(stepCount % rlSequence.length).toInt()] == 'R') this.substring(12, 15)
        else this.substring(7, 10)
}
