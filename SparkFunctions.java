package com.ninad

import org.apache.spark.sql.Dataset; 

public class SparkFunctions {

  public static void main(String[] arguments){
      
      // Create a session
      SparkSession sparkSession = SparkSession.builder().appName("SparkFunctions").master("local").getOrCreate();
     
     // Read the Data
     DataSet<Row> users =  sparkSession.read().option("header","true").csv("users.csv");
     
     // See sample data 
     users.show();
     
     // Cache and create a View
     users.createOrReplaceTempView("users")
      
     // Use the Rank Function 
     DataSet<Row> usersRank = sparkSession.sql("select amount, rank() over(order by amount desc) as rank from users");
                     
    // See sample data 
     usersRank.show();
   
       
    
    
  }

}
