import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object SparkScalaCode {

  val rootLogger = Logger.getRootLogger()
  rootLogger.setLevel(Level.ERROR)

  println("Hello world.!")

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("SparkScalaCode")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    println("First SparkContext: ")
    println("APP Name : " + spark.sparkContext.appName);
    println("Deploy Mode : " + spark.sparkContext.deployMode);
    println("Master : " + spark.sparkContext.master);

    val mydf = spark.read.format("csv").option("header", "true").load("/Users/c0s0etz/Documents/SampleData/SalesRecords.csv")

    mydf.show(false)

    println("mydf count: " + mydf.count())
    spark.stop()
  }
}
