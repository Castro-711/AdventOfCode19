package com.advent.code.two

import org.scalatest.FlatSpecLike

class IntCodeProgramTest extends FlatSpecLike {

  behavior of "IntCodeProgram"

  it should "return an Array of Doubles when invoking readInFile" in {
    IntCodeProgram.readInFile("IntCodeData").foreach(println)
  }

  it should "return the correct value at index 0" in {
    println(IntCodeProgram.getNextOpcode(IntCodeProgram.readInFile("IntCodeData"), 0, 12, 2))
  }

  it should "return the correct noun & verb needed to produce 19690720" in {
    println(IntCodeProgram.calculateNounAndVerb(99, 99))
  }

}
