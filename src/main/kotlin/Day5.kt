import utils.Input

fun main() {
    println("Day 5")
    //            [L] [M]         [M]
    //        [D] [R] [Z]         [C] [L]
    //        [C] [S] [T] [G]     [V] [M]
    //[R]     [L] [Q] [B] [B]     [D] [F]
    //[H] [B] [G] [D] [Q] [Z]     [T] [J]
    //[M] [J] [H] [M] [P] [S] [V] [L] [N]
    //[P] [C] [N] [T] [S] [F] [R] [G] [Q]
    //[Z] [P] [S] [F] [F] [T] [N] [P] [W]
    // 1   2   3   4   5   6   7   8   9
    val cratesOne = listOf(
        ArrayDeque(listOf("Z", "P", "M", "H", "R")),
        ArrayDeque(listOf("P", "C", "J", "B")),
        ArrayDeque(listOf("S", "N", "H", "G", "L", "C", "D")),
        ArrayDeque(listOf("F", "T", "M", "D", "Q", "S", "R", "L")),
        ArrayDeque(listOf("F", "S", "P", "Q", "B", "T", "Z", "M")),
        ArrayDeque(listOf("T", "F", "S", "Z", "B", "G")),
        ArrayDeque(listOf("N", "R", "V")),
        ArrayDeque(listOf("P", "G", "L", "T", "D", "V", "C", "M")),
        ArrayDeque(listOf("W", "Q", "N", "J", "F", "M", "L")),
    )
    val cratesTwo = listOf(
        ArrayDeque(listOf("Z", "P", "M", "H", "R")),
        ArrayDeque(listOf("P", "C", "J", "B")),
        ArrayDeque(listOf("S", "N", "H", "G", "L", "C", "D")),
        ArrayDeque(listOf("F", "T", "M", "D", "Q", "S", "R", "L")),
        ArrayDeque(listOf("F", "S", "P", "Q", "B", "T", "Z", "M")),
        ArrayDeque(listOf("T", "F", "S", "Z", "B", "G")),
        ArrayDeque(listOf("N", "R", "V")),
        ArrayDeque(listOf("P", "G", "L", "T", "D", "V", "C", "M")),
        ArrayDeque(listOf("W", "Q", "N", "J", "F", "M", "L")),
    )
    val input = Input.readAsLines("input/5")
    // haha
    val moves = input.map { it.replace("move", "").replace("from", "").replace("to", "") }
        .map { it.trim().split(" ").filter { split -> split.isNotBlank() }.map { split -> split.toInt() } }

    // Part One
    moves.forEach {
        val count = it[0]
        val from = it[1] - 1
        val to = it[2] - 1

        for (i in 1..count) {
            val crate = cratesOne[from].removeLast()
            cratesOne[to].addLast(crate)
        }
    }

    val msgOne = cratesOne.joinToString(separator = "") { it.removeLast() }
    println("Part one: $msgOne")

    // Part Two

    moves.forEach {
        val count = it[0]
        val from = it[1] - 1
        val to = it[2] - 1

        val crate = cratesTwo[from].takeLast(count)
        repeat(count) { cratesTwo[from].removeLast() }
        cratesTwo[to].addAll(crate)
    }

    val msgTwo = cratesTwo.joinToString(separator = "") { it.removeLast() }
    println("Part two: $msgTwo")
}

