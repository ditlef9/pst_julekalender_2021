import luke.day01.Day01
import luke.day02.Day02
import java.time.LocalDate
import java.time.Month
import kotlin.system.exitProcess

/*
 Filename: Main.kt
 Author: Mr X
 Date: 30.11.2021 21:43
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


fun main(args: Array<String>) {
    val today = LocalDate.now()

    // A set of all our lukes 😋
    val luker = setOf(Day01(), Day02())

    // Preset menu in December or else not
    var menu: String? =
        if (today.month == Month.DECEMBER && today.dayOfMonth < 25) today.dayOfMonth.toString() else null

    while (true) {
        println("--- \uD83C\uDF85 PST Xmas Calendar 2021 (${today}) \uD83C\uDF85 ---")

        if (menu == null) {
            println("Select your luke between 1-24. Write anything else to end the program.")
            print("Selection: ")
            menu = readLine()!!
        }

        // Go through valid menu possibilities
        luker.stream()
            .filter { luke -> luke.day().toString() == menu }
            .findFirst()
            .ifPresentOrElse({ currentLuke ->
                run {
                    println("\n--- Luke ${currentLuke.day()}: ${currentLuke.title()} ---")
                    currentLuke.run()

                    // Continue
                    println("Press [Enter] to continue")
                    readLine()
                    menu = null
                }
            }, {
                // Found no matching luke
                println("No such luke 😒")
                exitProcess(0)
            })
    }
}