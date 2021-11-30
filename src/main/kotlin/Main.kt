import day01.Day01
import java.text.SimpleDateFormat
import java.util.*

/*
 Filename: Main.kt
 Author: Mr X
 Date: 30.11.2021 21:43
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


fun main(args: Array<String>) {
    // Get todays date
    val d = SimpleDateFormat("d")
    val M = SimpleDateFormat("M")
    val yyyy = SimpleDateFormat("yyyy")
    val year = yyyy.format(Date())
    val month = M.format(Date())
    val day_single = d.format(Date())


    // Menu
    var endProgram = -1
    var menu = day_single
    while (endProgram <= 0) {
        println("--- \uD83C\uDF85 PST Xmas Calendar 2021 ($day_single. $month $year) \uD83C\uDF85 ---")
        if(menu.equals("NULL") || !(month.equals("12"))) {
            println("Select your luke between 1-24. Write anything else to end the program.")
            print("Selection: ")
            menu = readLine()!!
        }

        // Go through menu possibilities
        if (menu.equals("1")) {
            println("\n--- Luke 1 ---")

            val day01 = Day01() // Creating an instance from our class
            day01.run() // using the class methods by the instance we created.

            // Continue
            println("Press [Enter] to continue")
            readLine()
            menu = "NULL"
        } else if (menu.equals("2")) {
            println("\n--- Luke 2 ---")

            // Continue
            println("Press [Enter] to continue")
            readLine()
            menu = "NULL"
        } else if (menu.equals("3")) {
            println("\n--- Luke 3 ---")

            // Continue
            println("Press [Enter] to continue")
            readLine()
            menu = "NULL"
        } else {
            endProgram = 1
        }
    }
}