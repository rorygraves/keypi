package uk.co.fieldmark.keypi

import com.pi4j.io.gpio._
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent
import com.pi4j.io.gpio.event.GpioPinListenerDigital

object GpioInputTest  {

  def main(args: Array[String]): Unit = {
    System.out.println("<--Pi4J--> GPIO Listen Example ... started.")
    // create gpio controller
    val gpio: GpioController = GpioFactory.getInstance

    val inputs = List(RaspiPin.GPIO_00,RaspiPin.GPIO_01,RaspiPin.GPIO_02,RaspiPin.GPIO_03,RaspiPin.GPIO_04)
    val buttons = inputs.map(gpio.provisionDigitalInputPin(_, PinPullResistance.PULL_DOWN))
    // set shutdown state for this input pin
    buttons.foreach(_.setShutdownOptions(true))
    // create and register gpio pin listener
    buttons.foreach(_.addListener(new GpioPinListenerDigital() {
      override def handleGpioPinDigitalStateChangeEvent(event: GpioPinDigitalStateChangeEvent): Unit = { // display pin state on console
        System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin + " = " + event.getState)
      }
    }))
    System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.")
    // keep program running until user aborts (CTRL-C)
    while ( {
      true
    }) {
      Thread.sleep(500)
    }
    // stop all GPIO activity/threads by shutting down the GPIO controller
    // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
    // gpio.shutdown();   <--- implement this method call if you wish to terminate the Pi4J GPIO controller
  }
}