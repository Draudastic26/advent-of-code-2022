package utils

import java.io.File

object Input {
    fun readAsLines(fileName: String): List<String> = File(fileName).readLines()
}