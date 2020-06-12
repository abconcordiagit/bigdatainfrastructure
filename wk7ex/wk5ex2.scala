// Databricks notebook source
var x = List.range(1, 10)
println(x(0))

var y =  x.filter( (x: Int) => x%2 != 0)
//> y  : List[Int] = List(1, 3, 5, 7, 9)


def factorial(n: Int): Int =
{
  if (n == 0)
    return 1
  else
    return n * factorial(n-1)
}
factorial(5)
var z = List.range(1, factorial (5))

var zz =  z.filter( (z: Int) => z%2 != 0)

val names2 = y.map( (y: Int) => {factorial(y)})

