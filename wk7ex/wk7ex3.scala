// Databricks notebook source
//package org.apache.spark.examples.sql
import org.apache.spark
import org.apache.spark.sql.SaveMode
// $example on:init_session$
import org.apache.spark.sql.SparkSession

object insurance {
  def main(args: Array[String]):Unit = {

val spark = org.apache.spark.sql.SparkSession.builder
    .master("local[*]")
    .appName("Spark CSV Reader")
    .getOrCreate();

  spark.sparkContext.setLogLevel("ERROR")

  val df = spark.read.option("header",true).csv("insurance_csv.csv")
    println("1. Read insurance.csv file (uploaded in slack channel week6) :")
  df.show(numRows = 10, truncate=false)
  df.printSchema()

    df.createOrReplaceTempView("records")
    //println("1. Read insurance.csv file (uploaded in slack channel week6) :")
    //spark.sql("SELECT * FROM records").collect().foreach(println)
    val count = spark.sql("SELECT COUNT(*) FROM records").collect().head.getLong(0)
    println(s" 2. Print the size: $count")
    println(" 3. Print sex and count of sex (use group by in sql)  :")
    val count1 = spark.sql("SELECT sex,COUNT(age) FROM records GROUP BY sex").collect().foreach(println)
    println("4. Filter smoker=yes and print again the sex,count of sex: ")
    
    val count2= spark.sql("SELECT sex,COUNT(age) FROM records WHERE smoker == 'yes' GROUP BY sex").collect().foreach(println)
    println("5. Group by region and sum the charges (in each region), then print rows by  descending order (with respect to sum):")
    val count3= spark.sql("SELECT region,SUM(charges) as aa FROM records GROUP BY region ORDER BY aa DESC").collect().foreach(println)

  }

}

