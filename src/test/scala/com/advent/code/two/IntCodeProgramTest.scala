package com.advent.code.two

import org.scalatest.FlatSpecLike

class IntCodeProgramTest extends FlatSpecLike {

  behavior of "IntCodeProgram"

  it should "return an Array of Doubles when invoking readInFile" in {
    IntCodeProgram.readInFile("IntCodeData").foreach(println)
  }

  it should "return the value at position 0 when getNextOpCode is invoked" in {
    var arr = Array(1,0,0,0,99)

    IntCodeProgram.getNextOpcode(arr, 0)
  }

  it should "return the correct value at index 0" in {
    IntCodeProgram.getNextOpcode(IntCodeProgram.readInFile("IntCodeData"), 0)
  }

}
