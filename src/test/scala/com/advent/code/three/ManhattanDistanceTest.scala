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
    println(ManhattanDistance.getCoordsPath(moveSets._1))
    println(ManhattanDistance.getCoordsPath(moveSets._2))
  }

  it should "be able to find the close coord that intersects the two paths" in {
    val moves1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",").toList
    val moves2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",").toList

    val path1 = ManhattanDistance.getCoordsPath(moves1)
    val path2 = ManhattanDistance.getCoordsPath(moves2)

    val intersects = path1.intersect(path2)
    val sorted = intersects.map(c => c._1.abs + c._2.abs).sorted

    println(sorted)
    sorted(1) shouldBe 159
  }

  it should "calculate the correct answer for the challenge" in {
    val path1 = ManhattanDistance.getCoordsPath(moveSets._1)
    val path2 = ManhattanDistance.getCoordsPath(moveSets._2)

    val intersects = path1.intersect(path2)
    val sorted = intersects.map(c => c._1.abs + c._2.abs).sorted

    println(sorted)
  }

  behavior of "getDistinctCoords"

  it should "return the distinct coords only" in {
    val moves1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",").toList
    val moves2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",").toList

    val path1 = ManhattanDistance.getDistinctCoords(moves1).reverse
    val path2 = ManhattanDistance.getDistinctCoords(moves2).reverse

    println(path1)
    println(path2)
  }

  behavior of "Part 2"

  it should "be able to find the coord with the shortest distance and the coord" in {
    val moves1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",").toList
    val moves2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",").toList

    val path1 = ManhattanDistance.getCoordsPath(moves1)
    val path2 = ManhattanDistance.getCoordsPath(moves2)

    val dist1 = ManhattanDistance.getDistinctCoords(moves1).reverse
    val dist2 = ManhattanDistance.getDistinctCoords(moves2).reverse

    val intersects = path1.intersect(path2)
    val sorted = intersects.sorted

    val path1ToIntersection = path1.dropRight(path1.indexOf(sorted(1)))
    val path2ToIntersection = path2.dropRight(path2.indexOf(sorted(1)))

    println(path1ToIntersection)
    println(path1ToIntersection.size)

    println(path2ToIntersection)
    println(path2ToIntersection.size)

    val zip1 = moves1.zip(path1)
    val zip2 = moves2.zip(path2)
    println(zip1)
  }

}
