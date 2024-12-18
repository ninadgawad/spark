![Spark](./spark-logo-hd.png)

# Apache Spark
[Apache Spark](https://spark.apache.org/) is an open-source distributed general-purpose cluster-computing framework. Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance. Originally developed at the University of California, Berkeley's AMPLab, the Spark codebase was later donated to the Apache Software Foundation, which has maintained it since.


## Spark Overview
**Apache Spark** is a unified analytics engine for large-scale data processing. It provides high-level APIs in Java, Scala, Python and R, and an optimized engine that supports general execution graphs. It also supports a rich set of higher-level tools including Spark SQL for SQL and structured data processing, MLlib for machine learning, GraphX for graph processing, and Structured Streaming for incremental computation and stream processing.

##  Preview release of Spark 4.0
- https://spark.apache.org/news/spark-4.0.0-preview1.html
- **ANSI mode** enabled by default.
- **Python data source** support added.
- **Polymorphic Python UDTF** (User-Defined Table Function) introduced.
- **String collation support** included.
- New **VARIANT data type** available.
- **Streaming state store data source** introduced.
- **Structured logging** capabilities added.
- **Java 17** set as the default Java version.
- Plus many other enhancements.
  
## Latest Version: 3.5.3
- [Download 3.5.3](https://www.apache.org/dyn/closer.lua/spark/spark-3.5.3/spark-3.5.3-bin-hadoop3.tgz)
  * [Release Notes](https://spark.apache.org/releases/spark-release-3-5-3.html)  
- [Download 3.5.2](https://www.apache.org/dyn/closer.lua/spark/spark-3.5.2/spark-3.5.2-bin-hadoop3.tgz)
- [Download 3.5.1](https://www.apache.org/dyn/closer.lua/spark/spark-3.5.1/spark-3.5.1-bin-hadoop3.tgz)
- [Download 3.4.3](https://www.apache.org/dyn/closer.lua/spark/spark-3.4.3/spark-3.4.3-bin-hadoop3.tgz)
- [Download 3.3.2](https://www.apache.org/dyn/closer.lua/spark/spark-3.3.2/spark-3.3.2-bin-hadoop3.tgz)
- [Download 3.3.1](https://www.apache.org/dyn/closer.lua/spark/spark-3.3.1/spark-3.3.1-bin-hadoop3.tgz)
- [Download 3.2.3](https://www.apache.org/dyn/closer.lua/spark/spark-3.2.1/spark-3.2.3-bin-hadoop3.2.tgz)
- [Download 3.2.0](https://archive.apache.org/dist/spark/spark-3.2.0/spark-3.2.0-bin-hadoop2.7.tgz)

## New Features since 3.4.x 
1. Spark Connect: Spark Connect is a new client-server architecture introduced in Apache Spark 3.4 which solves the problem by decoupling Spark client applications and allowing remote connectivity to Spark clusters.
2. TorchDistributor Module to PySpark: This new module TorchDistributorin PySpark that makes it easier to do distributed training with PyTorch on Spark clusters.
3. DEFAULT Values: This default value support for columns feature in Spark 3.4 solves the problem by automatically inserting the default value for any column that is not explicitly specified.
4. TIMESTAMP WITHOUT TIMEZONE: New Data Type is a new feature in Spark 3.4 that allows you to represent timestamp values without a time zone.
5. Lateral Column: SQL SELECT List is a new feature in Spark 3.4 that allows you to reference columns from a subquery in the SELECT list of a main query. This is useful for a variety of tasks, such as joining data from multiple tables or performing aggregations on related data.
6. Bloom Filter: Bloom filter join is a new feature in Spark 3.4 that can be used to improve the performance of joins between large datasets.
7. Convert the Entire Source Dataframe to a Schema: Spark 3.4 has introduced Dataset.to(StructType) feature that solves the problem by making it easy to convert an entire DataFrame to a schema with a single line of code.
8. Parameterized SQL Queries: A parameterized SQL query is a query that uses named parameters instead of literal values. This means that the values of the parameters are not hard-coded into the query, but are instead passed in at runtime. This makes the query more reusable because the same query can be used with different values for the parameters. It also makes the query more secure, because it prevents attackers from injecting malicious code into the query

## With Hadoop 3 & Scala 2.13
- [Download Spark 3.5.2 with Hadoop3 and Scala 2.13](https://www.apache.org/dyn/closer.lua/spark/spark-3.5.2/spark-3.5.2-bin-hadoop3-scala2.13.tgz)

## Create the Docker base file 
Dockerfile

## Primary Users 
- Data Scientist 
- Data Engineers
- Software Developers
- Data Analysts

## Language Support
- Scala
- Python
- Java
- R


## Spark APIs
- RDDs
- DataFrames
- Datasets

## Popular Spark Use cases   4P's
- Parallel processing across cluster
- Performing adhoc queries for EDA
- Pipelines implementations for data 
- Processig and analyzing graph data and social networks 

# Run the Spark Submit on Kubernetes Cluster
Spark-Submit


## Create a Spark Session
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .master("local[1]")
  .appName("Spark App")
  .config("spark.driver.cores", "2")
  .getOrCreate()
  
val df = spark.read("data.json").json(jsonPath)
df.show()

```

## Spark Shell Read a Text File 
```
scala> val readMeDf  = spark.read.text("../README.md")
scala>readMeDf.show(5, false)
```
```
+--------------------------------------------------------------------------------+
|value                                                                           |
+--------------------------------------------------------------------------------+
|# Apache Spark                                                                  |
|                                                                                |
|Spark is a unified analytics engine for large-scale data processing. It provides|
|high-level APIs in Scala, Java, Python, and R, and an optimized engine that     |
|supports general computation graphs for data analysis. It also supports a       |
+--------------------------------------------------------------------------------+
only showing top 5 rows
```


## Spark App Flow 
![SparkApp](./SparkApp.png)


## Spark Operations
1) Transformations  e.g. orderBy() | groupBy() | join() | filter() | select() 
2) Actions  e.g. show() | count() | take()  | collect() | save() 


### Spark DataFrameReader methods
- spark.read.format("parquet").load("file.parquet")  or spark.read.load("file.parquet")
- spark.read.format("csv").option("inferSchema", "true").option("header", "true").option("mode", "PERMISSIVE").load("file.csv")
- spark.read.format("json").load("file.json")

### Spark DataFrameWriter df.write.format("json").mode("overwrite").save(location)methods
- df.write.format("parquet").mode("overwrite").option("compression", "snappy").save("parquet")
- df.write.format("csv").mode("overwrite").save("csvfile")
- df.write.format("json").mode("overwrite").save("jsonfile")
- df.write.format("avro").mode("overwrite").save("avrofile")
- df.write.format("orc").mode("overwrite").save("orcfile")


## Spark 3.2.1 Dependencies changes:
- [SPARK-37113]: Upgrade Parquet to 1.12.2
- [SPARK-37238]: Upgrade ORC to 1.6.12
- [SPARK-37534]: Bump dev.ludovic.netlib to 2.2.1
- [SPARK-37656]: Upgrade SBT to 1.5.7


## Reference Links
- https://github.com/apache/spark
- https://spark.apache.org/downloads.html
- http://livy.incubator.apache.org/get-started/
- https://archive.apache.org/dist/spark/
- https://spark.apache.org/downloads.html
- https://dlcdn.apache.org/spark/spark-3.3.1/spark-3.3.1-bin-hadoop3.tgz



