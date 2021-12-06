package luke.day06

import luke.Luke

fun main() {
    Day06().run()
}

class Day06 : Luke() {
    override fun day() = 6
    override fun title() = "Monday December 6th 2021 is a day off"

    override fun run() {
        println(title())
    }

}
