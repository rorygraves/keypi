import io.silverspoon.bulldog.core.gpio.DigitalOutput
import io.silverspoon.bulldog.core.platform.Board
import io.silverspoon.bulldog.core.platform.Platform
import io.silverspoon.bulldog.core.util.BulldogUtil
import io.silverspoon.bulldog.raspberrypi.RaspiNames


object BulldogLED {
  def main(args: Array[String]): Unit = { //Detect the board we are running on
    val board = Platform.createBoard
    //Set up a digital output
    val output = board.getPin(RaspiNames.P1_11).asInstanceOf[DigitalOutput]
    // Blink the LED
    output.high
    BulldogUtil.sleepMs(1000)
    output.low
  }
}