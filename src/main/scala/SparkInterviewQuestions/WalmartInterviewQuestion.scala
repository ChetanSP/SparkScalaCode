package SparkInterviewQuestions

import scala.util.control.Breaks._

// Program to return the first repeated character in a string:

object WalmartInterviewQuestion extends App {

  val givenString = "helo  ol"
  repeatedCharacterChecker(givenString)

  def repeatedCharacterChecker(givenString: String): Unit = {

    var mystring = givenString.replace(" ", "")
    println(s"The entered string is: $mystring")

    var myflag = false
    breakable {
      for (i <- 0 until mystring.length - 1) {
        if (mystring.substring(i + 1, mystring.length).contains(mystring(i))) {
          println(s"The first repeated character is: ${mystring(i)}")
          myflag = true
          break
        }
      }
    }
    if (!myflag) {
      println("There are no repeating characters")
    }
  }
}
