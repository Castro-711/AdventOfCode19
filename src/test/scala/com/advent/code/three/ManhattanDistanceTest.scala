package com.advent.code.three

import com.advent.code.three.ManhattanDistance.{Coordinate, Path}
import org.scalatest.{FlatSpecLike, Matchers}

class ManhattanDistanceTest extends FlatSpecLike with Matchers {

  behavior of "getData"

  it should "return the contents of the file when getData is invoked" in {
    println(ManhattanDistance.getData("ManhattanDistanceData"))
  }

  behavior of "calcNextCoord"

  it should "return a coordinate with the correct points" in {
    val origin = new ManhattanDistance.Coordinate(0, 0)

    val coordR = ManhattanDistance.Coordinate.calcNextCoord("R9", origin)
    println(s"coordR(${coordR.x}, ${coordR.y})")
    coordR.x shouldBe 9
    coordR.y shouldBe 0

    val coordL = ManhattanDistance.Coordinate.calcNextCoord("L9", origin)
    println(s"coordL(${coordL.x}, ${coordL.y})")
    coordL.x shouldBe -9
    coordL.y shouldBe 0

    val coordU = ManhattanDistance.Coordinate.calcNextCoord("U9", origin)
    println(s"coordU(${coordU.x}, ${coordU.y})")
    coordU.x shouldBe 0
    coordU.y shouldBe -9

    val coordD = ManhattanDistance.Coordinate.calcNextCoord("D9", origin)
    println(s"coordD(${coordD.x}, ${coordD.y})")
    coordD.x shouldBe 0
    coordD.y shouldBe 9

    val bogey = ManhattanDistance.Coordinate.calcNextCoord("Z9", origin)
    println(s"bogey(${bogey.x}, ${bogey.y})")
    bogey.x shouldBe 0
    bogey.y shouldBe 0
  }

  behavior of "extendPath"

  it should "return a new path with just with the new coordinate added to it" in {
    val coord1 = new ManhattanDistance.Coordinate(3, 4)
    val vector: Vector[Coordinate] = Vector.empty :+ coord1
    val oldPath = new ManhattanDistance.Path(vector)

    val newPath = Path.extendPath("U3", oldPath)
    println(s"oldPath last coord => ${oldPath.vec.last}")
    println(s"oldPath size => ${oldPath.vec.size}")
    println(s"newPath last coord => ${newPath.vec.last}")
    println(s"newPath size => ${newPath.vec.size}")
  }

  behavior of "PathGenerator"

  it should "return a Path populated with all the move coordinate" in {
    val moves = ManhattanDistance.getData("ManhattanDistanceData").split("\n")
    println(ManhattanDistance.PathGenerator(moves(0)))
    println(ManhattanDistance.PathGenerator(moves(1)))
  }

  behavior of "generateCoords"

  it should "return a vector of all the points from current" in {
    val x = ManhattanDistance.generateIntermediateCoords("X", 5, Coordinate(13, 2))
    val v = (0 to 5).map(c => new Coordinate(10, c)).toVector
    println(v)
    println(x)
  }


}
