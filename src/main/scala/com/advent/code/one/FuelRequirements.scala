package com.advent.code.one

/**
  * Take the mass, divide by 3, round down and subtract 2
  */

object FuelRequirements {

  def calcFuel(mass: Double): Double = {
    Math.floor(mass / 3) - 2
  }

  def sumOfModules(modules: List[Double]): Double = {

    def _sumOfModules(acc: Double, modules: List[Double]): Double = {
      modules match {
        case Nil => acc
        case h :: t => _sumOfModules(acc + calcAllRequiredFuel(h), t) // changing to suit PART 2
      }
    }

    _sumOfModules(0, modules)
  }

  def getFileAsString(filename: String): String = {
    val contents = io.Source.fromResource(filename).mkString
    contents
  }

  def getListOfModules(): List[Double] = {
    val modules = getFileAsString("FuelRequirementsData").split("\n").toList
    val doubles = modules.flatMap(s => scala.util.Try(s.toDouble).toOption)
    doubles
  }

  // PART 2
  // calculate recursive fuel count
  def calcAllRequiredFuel(mass: Double): Double = {

    def _calcAllRequiredFuel(acc: Double, massOfAddedFuel: Double): Double = {
      val extraFuel = calcFuel(massOfAddedFuel)

      extraFuel match {
        case x if x <= 0 => acc
        case x if x > 0 => _calcAllRequiredFuel(acc + x, x)
      }
    }

    _calcAllRequiredFuel(0, mass)
  }
}
