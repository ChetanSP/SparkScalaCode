import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level


object SparkScalaCode {

  val rootLogger = Logger.getRootLogger()
  rootLogger.setLevel(Level.ERROR)

  println("Hello world.!")

  def main(args:Array[String]): Unit ={

    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("SparkScalaCode")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    println("First SparkContext: ")
    println("APP Name : "+spark.sparkContext.appName);
    println("Deploy Mode : "+spark.sparkContext.deployMode);
    println("Master : "+spark.sparkContext.master);

    val mydf = spark.read.format("csv").option("header", "true").load("/Users/c0s0etz/Documents/OlympicData.csv")

    mydf.show(false)
    spark.stop()
  }
}
