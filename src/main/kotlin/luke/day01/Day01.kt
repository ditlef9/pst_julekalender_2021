package luke.day01

import luke.Luke
import java.io.File
import java.lang.Integer.parseInt

/*
 Filename: Day01.kt
 Author: Mr X
 Date: 30.11.2021 21:43
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */

class Day01 : Luke() {
    override fun day() = 1
    override fun title() = "Least Significant Bit Steganography"

    override fun run() {
        val buff = ByteArray(1230)
        File("src\\main\\kotlin\\luke\\day01\\eksempel_bakgrunnsbilde.png").inputStream().buffered().use { input ->
            while (true) {
                val sz = input.read(buff)
                if (sz <= 0) break

                ///at that point we have a sz bytes in the buff to process
                consumeArray(buff, 0, sz)
            }
        }

        val pixel = File("src\\main\\kotlin\\luke\\day01\\eksempel_bakgrunnsbilde.png").inputStream().readAllBytes()
        val string = String(pixel, Charsets.US_ASCII)
        println(string)
        readLine()

        var binaryMessage = ""
        var i = 0
        val n = pixel.size
        try {
            while (i < n) {
                var offset = 0
                while (offset < 2) {
                    var value = 0;
                    if (i + offset >= n) {
                        println("wood")
                        if (pixel[n - 1] % 2 != 0) {
                            value = 0;
                        }
                    } else {
                        if (pixel[i + offset] % 2 != 0) {
                            value = 1;
                        }
                    }

                    binaryMessage += value;
                    offset++
                }
                i += 4
            }
        } catch (e: Exception) {
            e.stackTrace
            println(e.message)
            println("-----i: $i. BinaryMessage.length: ${binaryMessage.length}")
        }

        var output: String? = ""
        var ii = 0
        while (ii < binaryMessage.length) {
            var c = 0
            for (j in 0..7) {
                try {
                    c = c shl 1
                    c = c or parseInt(binaryMessage[ii + j].toString())
                } catch (e: Exception) {
                    e.stackTrace
                    println(e.message)
                    if (output != null) {
                        println("" + j + " ii: $ii. ${ii + j} BinaryMessage.length: ${output.length}")
                    }
                }
            }
            output += "" + c.toChar().toString()
            ii += 8
        }
        println("$output")
        println()
        println(binaryMessage)


    } // run

    private fun consumeArray(buff: ByteArray, i: Int, sz: Int) {
        var lowestBit: Byte = 0
        for (index in sz - 1 downTo 0) {
            val currentLowestBit = buff[index].takeLowestOneBit()
            if (currentLowestBit != 0.toByte()) {
                lowestBit = currentLowestBit
                print("$lowestBit")
                break
            }
        }
    } // consumeArray

}