/*
 Filename: Main.kt
 Author: Mr X
 Date: 30.11.2021 21:43
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


fun main(args: Array<String>) {
    // Menu
    var endProgram = -1;
    var continueProgram = -1;
    while (endProgram <= 0) {
        println("--- \uD83C\uDF85 PST Xmas Calendar 2021 \uD83C\uDF85 ---")
        println("Select your luke between 1-24. Write anything else to end the program.")
        print("Selection: ")
        val menu = readLine()

        // Go trough menu possibilities
        if (menu.equals("1")) {
            println("\n--- Luke 1 ---")

            // Continue
            println("Press [Enter] to continue")
            val continueProgram = readLine()
        } else if (menu.equals("2")) {
            println("\n--- Luke 2 ---")

            // Continue
            println("Press [Enter] to continue")
            val continueProgram = readLine()
        } else if (menu.equals("3")) {
            println("\n--- Luke 3 ---")

            // Continue
            println("Press [Enter] to continue")
            val continueProgram = readLine()
        } else {
            endProgram = 1;
        }
    }
}