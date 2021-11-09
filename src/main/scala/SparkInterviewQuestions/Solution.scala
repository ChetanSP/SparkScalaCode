package SparkInterviewQuestions

import scala.util.control.Breaks._


object Solution extends App {

  println("Hello world.!")
  val nums = Array(-1,-2,-3,-4,-5)
  val target = -8
  val resultArray = twoSum(nums, target)
  println(s"The value of resultArray is :  ${resultArray(0)} and  ${resultArray(1)}")


  def FirsttwoSum(nums: Array[Int], target: Int): Array[Int] = {
    var res0 = 0
    var res1 = 0
    for (i <- 0 until nums.length)
      for (j <- i + 1 until nums.length)
        breakable {
          if (nums(i) + nums(j) == target) {
            println(s"The values of i and j are: $i and $j")
            res0 = nums(i)
            res1 = nums(j)
            break
          }
        }
    Array(res0, res1)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    var secondDigit_index = 0
    var firstDigit_index = 0
    breakable {
      for (i <- 0 until nums.length) {
        var secondDigit = (nums(i) - target)
        println(s"The firstDigit is: ${nums(i)}")
        println(s"The secondDigit is: $secondDigit")
        if ((secondDigit + nums(i)) == target && (nums.indexOf(secondDigit) != i) && (nums.indexOf(secondDigit) != -1)) {
          secondDigit_index = nums.indexOf(secondDigit)
          firstDigit_index = i
          break
        }
      }
    }
    return Array(firstDigit_index, secondDigit_index)
  }


}
