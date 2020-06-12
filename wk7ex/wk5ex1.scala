// Databricks notebook source
//println("Welcome to the Scala worksheet")
def frame (x:String, f:String => String):String = {
  f(x)

}                                             //> frame: (x: String, f: String => String)String

def greet1 (x:String):String = {
  println("Hello, "+x+" How u Doin?")

  var greet = "Hello, "+x+" How are you doing ?"
  return greet
}                                             //> greet1: (x: String)String

println(frame("Michael",greet1))                //> Hello, Michael How u Doin?
//| Hello, Michael How are you doing ?
println(frame("Michael",x => "Hello, "+x+" How are you doing ?"))
//> Hello, Michael How are you doing ?
println(greet1("Michael"))                      //> Hello, Michael How u Doin?

