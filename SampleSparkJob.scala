import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object SampleSparkJob extends  App {
  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("Sample Spark App")
    .getOrCreate();

  println(spark)
  println("Spark Version : " + spark.version)
  println("Spark App Name : " + spark.sparkContext.appName)
  println("Spark App ID : " + spark.sparkContext.applicationId)
}
