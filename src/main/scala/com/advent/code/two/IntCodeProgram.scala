package com.advent.code.two

object IntCodeProgram {

  val Dest = 3
  val OpCode = 4
  val Left = 1
  val Right = 2

  def readInFile(filename: String): Array[Int] = {
    val contents = io.Source.fromResource(filename).mkString.split(",")
    val ints = contents.map(s => s.toInt)
    ints
  }

  def getArrayWithProgramAlarm(source: Array[Int]): Array[Int] = {
    val sourceVar = source
    sourceVar(1) = 12
    sourceVar(2) = 2
    sourceVar
  }

  def getNextOpcode(source: Array[Int], index: Int): Unit = {
    val willExplode = if (index + OpCode > source.size) true else false

    val sourceVar = source

    sourceVar(1) = 12
    sourceVar(2) = 2

    val leftIndex = sourceVar(index + Left)
    val rightIndex = sourceVar(index + Right)
    val destIndex = sourceVar(index + Dest)

    sourceVar(index) match {
      case 1 if !willExplode =>
        sourceVar(destIndex) = sourceVar(leftIndex) + sourceVar(rightIndex)
        getNextOpcode(sourceVar, index + OpCode)
      case 2 if !willExplode =>
        sourceVar(destIndex) = sourceVar(leftIndex) * sourceVar(rightIndex)
        getNextOpcode(sourceVar, index + OpCode)
      case 99 => println(s"result => ${sourceVar(0)}")
    }
  }
}
