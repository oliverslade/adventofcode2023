fun main(args: Array<String>) {

    //Day One
    val dayOne = DayOne()
    val filePath = "src/inputs/day_one.txt"
    val inputList = dayOne.readValuesFromFile(filePath)
    val result = dayOne.sumCalibrationValues(inputList)

    println("Day One, Part One: The sum of calibration values is: $result")
}