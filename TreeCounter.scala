package org.ninad.spark.samples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
* Usage: TreeCounter <tree_file_dataset>
*/
object TreeCounter {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("TreeCounter")
      .getOrCreate()

    if (args.length < 1) {
      print("Usage: TreeCounter <tree_file_dataset>")
      sys.exit(1)
    }
    // get the tree data set file name
    val treeFile = args(0)
    // read the file into a Spark DataFrame
    val treeDF = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(package org.ninad.spark.samples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
* Usage: TreeCounter <tree_file_dataset>
*/
object TreeCounter {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("TreeCounter")
      .getOrCreate()

    if (args.length < 1) {
      print("Usage: TreeCounter <tree_file_dataset>")
      sys.exit(1)
    }
    // get the tree data set file name
    val treeFile = args(0)
    // read the file into a Spark DataFrame
    val treeDF = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(treeFile)
    // display DataFrame
    treeDF.show(5, false)

    // aggregate count of all colors and groupBy state and color
    val counttreeDF = treeDF.select("State", "Color", "Count")
        .groupBy("State", "Color")
        .sum("Count")
        .orderBy(desc("sum(Count)"))

    // show all the resulting aggregation for all the dates and colors
    counttreeDF.show(60)
    println(s"Total Rows = ${counttreeDF.count()}")
    println()

    // find the aggregate count for NY by filtering
    val nyCountMnNDF = treeDF.select("*")
      .where(col("State") === "NY")
      .groupBy("State", "Color")
      .sum("Count")
      .orderBy(desc("sum(Count)"))

    // show the result 
    nyCountMnNDF.show(10)
  }
})
    // display DataFrame
    treeDF.show(5, false)

    // aggregate count of all colors and groupBy state and color
    val counttreeDF = treeDF.select("State", "Color", "Count")
        .groupBy("State", "Color")
        .sum("Count")
        .orderBy(desc("sum(Count)"))

    // show all the resulting aggregation for all the dates and colors
    counttreeDF.show(60)
    println(s"Total Rows = ${counttreeDF.count()}")
    println()

    // find the aggregate count for NY by filtering
    val nyCountMnNDF = treeDF.select("*")
      .where(col("State") === "NY")
      .groupBy("State", "Color")
      .sum("Count")
      .orderBy(desc("sum(Count)"))

    // show the result 
    nyCountMnNDF.show(10)
  }
}
