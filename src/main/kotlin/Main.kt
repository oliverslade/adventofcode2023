fun main(args: Array<String>) {

    //Day One
    val dayOne = DayOne()
    val filePath = "src/inputs/day_one.txt"
    val inputList = dayOne.readValuesFromFile(filePath)
    val dayOneResult = dayOne.sumCalibrationValues(inputList)

    println("Day One: the sum of calibration values is: $dayOneResult")

    //Day two
    val dayTwo = DayTwo()
    val dayTwoFilePath = "src/inputs/day_two.txt"
    val games = dayTwo.readGamesFromFile(dayTwoFilePath)
    val result = dayTwo.solve(games)
    println("Day Two: Sum of IDs of possible games: $result")

    //Day three
    val dayThree = DayThree()
    val dayThreeFilePath = "src/inputs/day_three.txt"
    val schematics = dayThree.readSchematicFromFile(dayThreeFilePath)
    val sum = dayThree.calculateTotalGearRatios(schematics)
    println("Day Three: Sum of all part numbers: $sum")

    //Day four
    val dayFour = DayFour()
    val dayFourFilePath = "src/inputs/day_four.txt"
    val scratchcards = dayFour.readScratchcardsFromFile(dayFourFilePath)
    val totalCards = dayFour.calculateTotalCards(scratchcards)
    println("Day Four: Total scratchcards: $totalCards")
}