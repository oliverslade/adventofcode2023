import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main() {

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

    //Day five
//    val dayFiveFilePath = "src/inputs/day_five.txt"
//    val dayFive = DayFive()
//    val fileContent = File(dayFiveFilePath).readText()
//
//    val almanacSections = fileContent.split("\n\n")
//    val seedSection = almanacSections.first()
//    val seedData = seedSection.substringAfter("seeds:").trim()
//    val seedRanges = seedData.split(" ")
//        .windowed(2, 2)
//        .map { (start, length) -> start.toLong() to length.toLong() }
//
//    val mappings = dayFive.parseAlmanac(almanacSections.drop(1).joinToString("\n\n"))
//
//    val lowestLocation = dayFive.findLowestLocation(seedRanges, mappings)
//    println("Day Five: The lowest location number is: $lowestLocation")

    //Day six
    val daySixFilePath = "src/inputs/day_six.txt"

    val daySix = DaySix()
    val waysToWin = daySix.calculateWaysToWinSingleRaceFromFile(daySixFilePath)
    println("Day Six: Number of ways to win the race: $waysToWin")

    //Day eight
    val dayEightPaths = Paths.get("src/inputs/day_eight.txt")
    val lines = Files.readAllLines(dayEightPaths)

    val dayEight = DayEight()
    val steps = dayEight.navigate(lines)
    println("Day Eight: Steps to reach ZZZ: $steps")

    //Day nine
    val dayNineInput = File("src/inputs/day_nine.txt").readLines()
    val dayNine = DayNine()
    val sumOfValues = dayNine.calculateSumOfPreviousValues(dayNineInput)
    println("Day Nine: Sum of extrapolated values: $sumOfValues")
}