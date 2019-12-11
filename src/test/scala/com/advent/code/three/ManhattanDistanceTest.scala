package com.advent.code.three

import com.advent.code.three.ManhattanDistance.{Coordinate, PathGenerator}
import org.scalatest.{FlatSpecLike, Matchers}

class ManhattanDistanceTest extends FlatSpecLike with Matchers {

  lazy val moveSets = ManhattanDistance.getListOfMoves()
  lazy val criticalPath1 = PathGenerator(moveSets._1)

  behavior of "getData"

  it should "return the contents of the file when getData is invoked" in {
    println(ManhattanDistance.getData("ManhattanDistanceData"))
  }

  behavior of "generateNextCoords"

  it should "produce the full vector of coords from starting point up until the final coord" in {
    val move = "R24"
//    val startCoord = Coordinate(7, 13)
//    val finalCoord = Coordinate(31, 13)

//    val vec = ManhattanDistance.generateNextCoord(move, startCoord)

//    vec.last shouldBe finalCoord
//    vec.size shouldBe 25
  }

  behavior of "getListOfMoves"

  it should "return a tuple of both move sets" in {

    println(moveSets._1)
    println(moveSets._2)
  }

  behavior of "PathGenerator"

  it should "return a vector with all of the points of interest" in {
    println(criticalPath1)
  }

  behavior of "generateIntermediateCoords"

  it should "return a vector of all the points from current" in {
//    val x = ManhattanDistance.generateIntermediateCoords("X", 5, Coordinate(13, 2))
//    val v = (0 to 5).map(c => Coordinate(10, c)).toVector
//    println(v)
//    println(x)
  }

  it should "return the full path for one of the moves" in {
//    criticalPath1.vec.map(c => ManhattanDistance.generateIntermediateCoords(c.))
  }


}
