package com.advent.code.three

object ManhattanDistance {

  case class Coordinate(x: Int, y: Int, axis: String) {
    override def toString(): String = s"(${this.x}, ${this.y})"
  }

  def generateNextCoord(move: String, c: Coordinate): Coordinate = {
    val direction = move.charAt(0)
    val distance = move.substring(1).toInt

    direction match {
    case 'R' => Coordinate(c.x + distance, c.y, "X")
    case 'L' => Coordinate(c.x - distance, c.y, "X")
    case 'U' => Coordinate(c.x, c.y - distance, "Y")
    case 'D' => Coordinate(c.x, c.y + distance, "Y")
    case _ => println(s"Bogey direction in the move $c"); c
    }
  }

  def generateIntermediateCoords(axis: String, distance: Int, start: Coordinate): Vector[Coordinate] = {
    axis match {
      case "Y" => (start.y to start.y + distance).map(c => Coordinate(start.x, c, "Y")).toVector
      case "X" => (start.x to start.x + distance).map(c => Coordinate(c, start.y, "X")).toVector
      case _ => println("Not a valid axis !!!"); Vector.empty[Coordinate]
    }
  }

  def getListOfMoves(): (List[String], List[String]) = {
    val moveSets = getData("ManhattanDistanceData").split("\\n")

    val movesOne = moveSets(0).split(",").toList
    val movesTwo = moveSets(1).split(",").toList

    (movesOne, movesTwo)
  }

  case class Path(vec: Vector[Coordinate])
  case object Path {}

  object PathGenerator {
    def apply(moves: List[String]): Path = {

      def createCoordsVector(vec: Vector[Coordinate], l: List[String]): Vector[Coordinate] = {
        l match {
          case Nil => vec
          case h :: t if vec.isEmpty => createCoordsVector(vec :+ generateNextCoord(h, Coordinate(0, 0, h))._1, t)
          case h :: t => createCoordsVector(vec :+ generateNextCoord(h, vec.last)._1, t)
        }
      }
      new Path(createCoordsVector(Vector.empty[Coordinate], moves))
    }
  }

  /**
    * An edge is a line between 2 coordinates
    * e.g. (1004, 0) and (1004, 53)
    * the edge here is the line down the y-axis with a distance of 53
    *
    * A cross section is a point of intersection - another Coordinate
    *
    * To calculate any cross sections between the two paths
    * take path1's first edge and see if it intersects any of path2's entire list of edges
    *
    *
    * p1 = (0, 4), (10, 4)
    * p2 = (-5, 5), (-5, 3)
    *
    * you take the point that has not changed and you check if the edge intersects it
    */

  def getData(filename: String): String = {
    val contents = io.Source.fromResource(filename).mkString
    contents
  }
}


