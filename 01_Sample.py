import findspark
findspark.init()

import pyspark
from pyspark import SparkContext

sc = SparkContext("local", "First App")

logFile = "<location to Readme file>\README.md"  

logData = sc.textFile(logFile).cache()

words = sc.parallelize (
   [
   "A", 
   "B", 
   "C", 
   "D", 
   "E", 
   "F", 
   "G", 
   "H",
   "I", 
   "J",
   "K"]
)
counts = words.count()
print ("Number of elements in RDD =",counts)

coll = words.collect()

print(coll)
