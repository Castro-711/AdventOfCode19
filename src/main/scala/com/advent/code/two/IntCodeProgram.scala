package com.advent.code.two

import scala.util.Random

object IntCodeProgram {

  val Left = 1
  val Right = 2
  val Dest = 3
  val OpCode = 4

  def readInFile(filename: String): Array[Int] = {
    val contents = io.Source.fromResource(filename).mkString.split(",")
    val ints = contents.map(s => s.toInt)
    ints
  }

  def getNextOpcode(source: Array[Int], index: Int, noun: Int, verb: Int): Long = {
    val willExplode = if (index + OpCode > source.size) true else false

    val sourceVar = source
    sourceVar(1) = noun
    sourceVar(2) = verb

    val leftIndex = sourceVar(index + Left)
    val rightIndex = sourceVar(index + Right)
    val destIndex = sourceVar(index + Dest)

    sourceVar(index) match {
      case 1 if !willExplode =>
        sourceVar(destIndex) = sourceVar(leftIndex) + sourceVar(rightIndex)
        getNextOpcode(sourceVar, index + OpCode, noun, verb)
      case 2 if !willExplode =>
        sourceVar(destIndex) = sourceVar(leftIndex) * sourceVar(rightIndex)
        getNextOpcode(sourceVar, index + OpCode, noun, verb)
      case 99 => sourceVar(0)
    }
  }

  def calculateNounAndVerb(noun: Int, verb: Int): (Int, Int) = {
    val source = readInFile("IntCodeData")

    def _calculateNounAndVerb(n: Int, v: Int): (Int, Int) = {
      getNextOpcode(source, 0, noun, verb) match {
        case 196907 => (noun, verb)
        case _ => _calculateNounAndVerb(Random.nextInt(n), Random.nextInt(v))
      }
    }

    _calculateNounAndVerb(noun, verb)
  }
}
