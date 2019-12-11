package com.advent.code.three

import org.scalatest.{FlatSpecLike, Matchers}

class ManhattanDistanceTest extends FlatSpecLike with Matchers {

  lazy val moveSets = ManhattanDistance.getListOfMoves()

  behavior of "getData"

  it should "return the contents of the file when getData is invoked" in {
    println(ManhattanDistance.getData("ManhattanDistanceData"))
  }

  behavior of "getListOfMoves"

  it should "return a tuple of both move sets" in {

    println(moveSets._1)
    println(moveSets._2)
  }

  behavior of "getCoordsPath"

  it should "get the distinct coords" in {
    println(ManhattanDistance.getCoordsPath(moveSets._1).reverse)
    println(ManhattanDistance.getCoordsPath(moveSets._2))
  }

  it should "fill the paths to the critical points" in {
    val moves1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",").toList
    val moves2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",").toList

    println(ManhattanDistance.getCoordsPath(moves1))
    println(ManhattanDistance.getCoordsPath(moves2))

  }

}
