
import org.apache.spark.sql.SparkSession


object RunSparkApp{
  
  def main(args: args: Array[String]){
    
    val spark:SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()
   
    //Create RDD from parallelize    
   val dataSeq = Seq(("Java", 20000), ("Go", 100000), ("Scala", 3000))   
   val rdd=spark.sparkContext.parallelize(dataSeq)
    
   //Create RDD from external Data source
   val rdd2 = spark.sparkContext.textFile("/data/file.csv")
  }
}
