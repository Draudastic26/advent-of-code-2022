import utils.Input

fun main() {
    println("Day 6")

    val input = Input.readAsString("input/6")

    // Part 1
    var marker = findMarker(input, 4)
    println("Part one marker at $marker")

    // Part 2
    marker = findMarker(input, 14)
    println("Part two marker at $marker")
}

private fun findMarker(input: String, distinctCharacters: Int): Int {
    for (i in input.indices) {
        val substring = input.substring(i, i + distinctCharacters)
        val length = substring.length
        if (substring.toSet().size == length) return i + distinctCharacters
    }
    return -1
}