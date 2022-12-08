package utils

import java.io.File

object Input {
    fun readAsLines(fileName: String): List<String> = File(fileName).readLines()
    fun readAsString(fileName: String): String = File(fileName).readText()
    fun readAs2D(fileName: String): Array<IntArray> {
        val lines = readAsLines(fileName)
        val rows = lines.size
        val columns = lines.first().length
        val matrix = Array(rows) { IntArray(columns) }
        lines.forEachIndexed { indexRow, row ->
            row.forEachIndexed { indexCol, value ->
                matrix[indexRow][indexCol] = value.digitToInt()
            }
        }
        return matrix
    }
}