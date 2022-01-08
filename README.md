# Spark
Apache Spark is an open-source distributed general-purpose cluster-computing framework. Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance. Originally developed at the University of California, Berkeley's AMPLab, the Spark codebase was later donated to the Apache Software Foundation, which has maintained it since.

# Create the Docker base file 
Dockerfile

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


## Links
https://spark.apache.org/downloads.html

