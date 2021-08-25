package SparkInterviewQuestions

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql._
import org.apache.spark.sql.expressions.Window._
import org.apache.spark.sql.functions.{col, lag, sum}


object InterviewQuestions extends App {


  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("InterviewQuestions")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  /*
      +---+-----+
      |ID |NewID|
      +---+-----+
      |1  |1    |
      |2  |3    |
      |3  |5    |
      |4  |7    |
      |5  |9    |
      |6  |11   |
      |7  |13   |
      |8  |15   |
      |9  |17   |
      |10 |19   |
      +---+-----+
  */

  val mydf1 = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toDF("ID")

  val windo1 = orderBy("ID")

  mydf1.withColumn("NewID", lag("ID", 1, 0).over(windo1) + col("ID")).show(false)

  /*
      +---+-----+
      |ID |NewID|
      +---+-----+
      |1  |1    |
      |2  |3    |
      |3  |6    |
      |4  |10   |
      |5  |15   |
      |6  |21   |
      |7  |28   |
      |8  |36   |
      |9  |45   |
      |10 |55   |
      +---+-----+
  */

  val windo2 = orderBy("ID").rangeBetween(org.apache.spark.sql.expressions.Window.unboundedPreceding, 0)

  mydf1.withColumn("NewID", sum("ID").over(windo2)).show(false)

}
