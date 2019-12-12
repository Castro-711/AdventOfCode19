package com.advent.code.four

/**
  * Password Key facts:
  *  It is a six-digit number.
  *  The value is within the range given in your puzzle input.
  *  Two adjacent digits are the same (like 22 in 122345).
  *  Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
  */

object SecureContainer {

  // UpperCamelCase for constants in Scala
  val LowerBound = 206938
  val UpperBound = 679128
  val possibilities = (LowerBound + 1 until UpperBound).toList

  /**
    * Verifies that the password is the correct length
    * @param password
    * @return
    */
  def isSixDigits(password: String): Boolean = {
    password match {
      case p if p.length == 6 => true
      case _ => false
    }
  }

  /**
    * Ensures that the password is within the given range
    * @param password
    * @return
    */
  def withinRange(password: Int): Boolean = {
   if (password > LowerBound && password < UpperBound) true
   else false
  }

  /**
    * Checks to find if there are two identical consecutive
    * digits within the password
    * @param password
    * @return
    */
  def hasSameAdjacentDigits(password: String): Boolean = {
    def _hasSame(pword: List[Char]): Boolean = {
      pword match {
        case Nil => false
        case h :: neck :: _ if h == neck => true
        case _ :: t => _hasSame(t)
      }
    }
    _hasSame(password.toList)
  }

  /**
    * this checks if the preceding character i is greater than i + 1
    * when a single use case of that is met this function returns false
    * @param password
    * @return
    */
  def hasIncrementingDigits(password: String): Boolean = {
    def _hasInc(pword: List[Char]): Boolean = {
      pword match {
        case Nil => true
        case h :: neck :: _ if h > neck => false
        case _ :: t => _hasInc(t)
      }
    }
    _hasInc(password.toList)
  }

  /**
    * Performs all of the checks to verify if the password is valid
    * @param password
    * @return
    */
  def passwordMeetsCriteria(password: String): Boolean = {
    isSixDigits(password) && withinRange(password.toInt) && hasSameAdjacentDigits(password) && hasIncrementingDigits(password)
  }

  /**
    * Calculates the valid passwords between the ranges for Part 1
    * @return
    */
  def findValidPasswordsBetweenRanges(): List[String] = {
    val validPasswords = possibilities.map(p => p.toString).filter(passwordMeetsCriteria(_))
    validPasswords
  }
}
