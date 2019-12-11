package com.advent.code.three

object ManhattanDistance {

  def getCoordsPath(moves: List[String]): List[(Int, Int)] = {

    def _getCoordsPath(_moves: List[String], path: List[(Int, Int)], st: (Int, Int)): List[(Int, Int)] = {

      _moves match {
        case Nil => path
        case head :: tail =>
          val direction = head.charAt(0)
          val distance = head.substring(1).toInt

          direction match {
            case 'R' => _getCoordsPath(tail, path ::: (st._1 to st._1 + distance).map(c => (c, st._2)).toList, (st._1 + distance, st._2))
            case 'L' => _getCoordsPath(tail, path ::: (st._1 to st._1 - distance by -1).map(c => (c, st._2)).toList, (st._1 - distance, st._2))
            case 'U' => _getCoordsPath(tail, path ::: (st._2 to st._2 + distance).map(c => (st._1, c)).toList, (st._1, st._2 + distance))
            case 'D' => _getCoordsPath(tail, path ::: (st._2 to st._2 - distance by -1).map(c => (st._1, c)).toList, (st._1, st._2 - distance))
            case  _  => println("Not a valid direction"); List.empty
          }
      }
    }
    _getCoordsPath(moves, List.empty[(Int, Int)], (0, 0))
  }

  def getListOfMoves(): (List[String], List[String]) = {
    val moveSets = getData("ManhattanDistanceData").split("\\n")

    val movesOne = moveSets(0).split(",").toList
    val movesTwo = moveSets(1).split(",").toList

    (movesOne, movesTwo)
  }

  def getData(filename: String): String = {
    val contents = io.Source.fromResource(filename).mkString
    contents
  }
}


