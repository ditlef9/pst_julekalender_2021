package luke.day09

import luke.Luke

/*
Fikk tilsendt denne filen fra IT-avdelingen i går,
de har TAPpet filen ut av nettverket.
Har du mulighet til å se på den? Mulig den gir oss litt mer informasjon angående lekkasjen vi hadde ut til SPST.
Husk, dette forblir mellom oss, i tilfelle det viser seg å være en av våre egne.
 */
fun main() {
    Day09().run()
}
class Day09 : Luke() {
    override fun day() = 9
    override fun title() = "npst_02_12_21_18_00.pcap"

    override fun run() {
        println(title())
    }
}