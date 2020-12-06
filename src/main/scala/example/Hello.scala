package example

object Goodbye {
  def main(args: Array[String]): Unit = {
    println("Bye")
  }
}
object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "goodbye"
}
