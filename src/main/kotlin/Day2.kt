import utils.Input

fun main() {
    println("Day 2")
    val lines = Input.readAsLines("input/2")

    //Rock A X
    //Paper B Y
    //Scissors C Z
    val combinations = mapOf(
        "A X" to 4,
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6,
    )
    val scoreA = lines.sumOf { combinations[it]!! }
    println("Strategy A Score: $scoreA")

    //X lose
    //Y draw
    //Z win
    val replacements = mapOf(
        "A X" to "A Z",
        "A Y" to "A X",
        "A Z" to "A Y",
        "B X" to "B X",
        "B Y" to "B Y",
        "B Z" to "B Z",
        "C X" to "C Y",
        "C Y" to "C Z",
        "C Z" to "C X",
    )
    val scoreB = lines.map { replacements[it] }.sumOf { combinations[it]!! }
    println("Strategy B Score: $scoreB")
}

