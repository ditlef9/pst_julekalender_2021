package luke.day05

import luke.Luke

fun main() {
    Day05().run()
}

class Day05 : Luke() {
    override fun day() = 5
    override fun title() = "SQL injections"

    override fun run() {
        println("PST{5Q1_1nj€Ⓒt10n}")
    }
}
