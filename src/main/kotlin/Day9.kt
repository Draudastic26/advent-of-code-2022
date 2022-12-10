import utils.Input
import kotlin.math.abs
import kotlin.math.pow

val up = Vec2(0, 1)
val right = Vec2(1, 0)
val down = Vec2(0, -1)
val left = Vec2(-1, 0)

fun main() {
    println("Day 9 - Part One")

    val input = Input.readAsLines("input/9")

    var headPos = Vec2(0, 0)
    var tailPos = Vec2(0, 0)
    var tailPath = mutableSetOf(Vec2(0, 0))

    val instructions = input.map { it.split(" ") }.map { Pair(it[0], it[1].toInt()) }
    instructions.forEach { (direction, steps) ->
        repeat(steps) {
            when (direction) {
                "U" -> headPos += up
                "R" -> headPos += right
                "D" -> headPos += down
                "L" -> headPos += left
            }
            if (distanceSqr(headPos, tailPos) > 2) {
                tailPos = evaluateTail(headPos, tailPos)
                tailPath.add(tailPos)
            }
        }
    }
    println("Result part one: ${tailPath.size}")

    println("Day 9 - Part Two")
    val tails = (0..9).map { Vec2(0, 0) }.toMutableList()
    tailPath = mutableSetOf(Vec2(0, 0))
    instructions.forEach { (direction, steps) ->
        repeat(steps) {
            when (direction) {
                "U" -> tails[0] += up
                "R" -> tails[0] += right
                "D" -> tails[0] += down
                "L" -> tails[0] += left
            }
            (0 until 9).forEach {
                if (distanceSqr(tails[it], tails[it + 1]) > 2) {
                    tails[it + 1] = evaluateTail(tails[it], tails[it + 1])
                }
            }
            tailPath.add(tails.last())
        }
    }
    println("Result part two: ${tailPath.size}")
}

fun evaluateTail(headPos: Vec2, tailPos: Vec2): Vec2 {
    val diff = headPos - tailPos
    var movement = Vec2(0, 0)
    if (abs(diff.x) >= 1)
        movement += if (diff.x > 0) right else left
    if (abs(diff.y) >= 1)
        movement += if (diff.y > 0) up else down
    return tailPos + movement
}

data class Vec2(val x: Int, val y: Int) {
    operator fun plus(vec: Vec2) = Vec2(x + vec.x, y + vec.y)
    operator fun minus(vec: Vec2) = Vec2(x - vec.x, y - vec.y)
}

fun distanceSqr(from: Vec2, to: Vec2) = (to.x - from.x).toFloat().pow(2) + (to.y - from.y).toFloat().pow(2)
