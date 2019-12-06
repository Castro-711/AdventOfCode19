package com.advent.code.three

object ManhattanDistance {

  case class Coordinate(x: Int, y: Int) {
    override def toString(): String = s"(${this.x}, ${this.y})"
  }
  case object Coordinate {
    def calcNextCoord(move: String, c: Coordinate): Coordinate = {
      val direction = move.charAt(0)
      val distance = move.substring(1).toInt

      direction match {
        case 'R' => new Coordinate(c.x + distance, c.y)
        case 'L' => new Coordinate(c.x - distance, c.y)
        case 'U' => new Coordinate(c.x, c.y - distance)
        case 'D' => new Coordinate(c.x, c.y + distance)
        case _ => println(s"Bogey direction in the move $c"); c
      }
    }
  }

  case class Path(vec: Vector[Coordinate])
  case object Path {
    def extendPath(move: String, p: Path): Path = {
      val lastCoord = p.vec.last
      val nextCoord = Coordinate.calcNextCoord(move, lastCoord)
      new Path(p.vec :+ nextCoord)
    }
  }

  object PathGenerator {
    def apply(moves: String): Path = {
      val movesArray = moves.split(",").toList

      def createCoordsVector(vec: Vector[Coordinate], l: List[String]): Vector[Coordinate] = {
        l match {
          case Nil => vec
          case h :: t if vec.isEmpty => createCoordsVector(vec :+ Coordinate.calcNextCoord(h, Coordinate(0, 0)), t)
          case h :: t => createCoordsVector(vec :+ Coordinate.calcNextCoord(h, vec.last), t)
        }
      }

      new Path(createCoordsVector(Vector.empty[Coordinate], movesArray))
    }
  }

  def generateIntermediateCoords(axis: String, distance: Int, start: Coordinate): Vector[Coordinate] = {
    val vec = Vector.empty[Coordinate]
    axis match {
      case "Y" => (start.y to start.y + distance).map(c => new Coordinate(start.x, c)).toVector
      case "X" => (start.x to start.x + distance).map(c => new Coordinate(c, start.y)).toVector
      case _ => println("Not a valid axis !!!"); Vector.empty[Coordinate]
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


