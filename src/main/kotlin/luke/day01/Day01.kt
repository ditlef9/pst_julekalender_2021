package luke.day01
import luke.Luke
import java.io.File
import java.nio.file.Paths

/*
 Filename: Day01.kt
 Author: Mr X
 Date: 30.11.2021 21:43
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */

class Day01: Luke() {
    override fun day() = 1
    override fun title() = "Least Significant Bit Steganography"

    override fun run() {
        val buff = ByteArray(1230)
        File("src\\main\\kotlin\\luke\\day01\\eksempel_bakgrunnsbilde.png").inputStream().buffered().use { input ->
            while(true) {
                val sz = input.read(buff)
                if (sz <= 0) break

                ///at that point we have a sz bytes in the buff to process
                consumeArray(buff, 0, sz)
            }
        }
    } // run

    private fun consumeArray(buff: ByteArray, i: Int, sz: Int) {
        println("$buff $i $sz")
    } // consumeArray

}