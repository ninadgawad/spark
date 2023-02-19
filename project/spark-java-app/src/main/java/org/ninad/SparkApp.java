package org.ninad;
import org.apache.spark.sql.SparkSession;
public class SparkApp
{
    public static void main( String[] args ) throws InterruptedException {
        SparkSession spark = SparkSession.builder().appName("Simple Application").master("local[1]").getOrCreate();
        Thread.sleep(50000);
        spark.stop();
    }
}
