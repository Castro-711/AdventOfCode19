package com.advent.code.one

import org.scalatest.{FlatSpecLike, Matchers}

class FuelRequirementsTest extends FlatSpecLike with Matchers {

  behavior of "calcFuel"

  it should "return 2 with a mass of 12" in {
    FuelRequirements.calcFuel(12) shouldBe 2
  }

  it should "return 2 with a mass of 14" in {
    FuelRequirements.calcFuel(14) shouldBe 2
  }

  it should "return 654 with a mass of 1969" in {
    FuelRequirements.calcFuel(1969) shouldBe 654
  }

  it should "return 33583 with a mass of 100756" in {
    FuelRequirements.calcFuel(100756) shouldBe 33583
  }

  behavior of "getFileAsString"

  it should "print the file contents" in {
    FuelRequirements.getFileAsString("FuelRequirementsData")
  }

  behavior of "getListOfModules"

  it should "print return a list containing each module" in {
    FuelRequirements.getListOfModules().foreach(println)
  }

  behavior of "sumOfModules"

  it should "return the sum of the required fuel for all of the modules" in {
    println(FuelRequirements.sumOfModules(FuelRequirements.getListOfModules()))
  }

  behavior of "calcAllRequiredFuel"

  it should "recursively calculate the extra fuel needed to for the mass of the fuel added" in {
    println(FuelRequirements.sumOfModules(FuelRequirements.getListOfModules()))
  }
}
