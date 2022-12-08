import utils.Input

fun main() {
    println("Day 8 - Part One")

    val input = Input.readAs2D("input/8")

    // Add borders
    val xLength = input.size
    val yLength = input.first().size
    var count = xLength * 2 + (yLength - 2) * 2

    for (y in (1 until xLength - 1)) {
        for (x in (1 until yLength - 1)) {
            val currentHeight = input[y][x]
            val northernTrees = (0 until y).map { input[it][x] }
            val easternTrees = (x + 1 until xLength).map { input[y][it] }
            val southernTrees = (y + 1 until yLength).map { input[it][x] }
            val westernTrees = (0 until x).map { input[y][it] }

            val isVisible =
                northernTrees.none { it >= currentHeight } || easternTrees.none { it >= currentHeight } || southernTrees.none { it >= currentHeight } || westernTrees.none { it >= currentHeight }
            if (isVisible) count++
        }
    }
    println("Result part one: $count")

    println("Day 8 - Part Two")

    var score = 0
    for (y in (1 until xLength - 1)) {
        for (x in (1 until yLength - 1)) {
            val currentHeight = input[y][x]
            val northernTrees = (0 until y).map { input[it][x] }.reversed()
            var countNorth = 0
            for (height in northernTrees) {
                countNorth++
                if (height >= currentHeight) break
            }
            var countEast = 0
            val easternTrees = (x + 1 until xLength).map { input[y][it] }
            for (height in easternTrees) {
                countEast++
                if (height >= currentHeight) break
            }
            var countSouth = 0
            val southernTrees = (y + 1 until yLength).map { input[it][x] }
            for (height in southernTrees) {
                countSouth++
                if (height >= currentHeight) break
            }
            var countWest = 0
            val westernTrees = (0 until x).map { input[y][it] }.reversed()
            for (height in westernTrees) {
                countWest++
                if (height >= currentHeight) break
            }
            val newScore = countNorth * countSouth * countEast * countWest
            if (newScore > score) {
                score = newScore
            }
        }
    }

    println("Result part two: $score")
}
