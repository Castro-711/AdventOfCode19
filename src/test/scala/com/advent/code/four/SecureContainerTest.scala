package com.advent.code.four

import org.scalatest.{FlatSpecLike, Matchers}

class SecureContainerTest extends FlatSpecLike with Matchers {

  behavior of "isSixDigits"

  it should "return true if the password is of length 6" in {
    SecureContainer.isSixDigits("123456") shouldBe true
    SecureContainer.isSixDigits("12345") shouldBe false
    SecureContainer.isSixDigits("1234567") shouldBe false
  }

  behavior of "withinRange"

  it should "return true if the password is within the bounds" in {
    SecureContainer.withinRange(206938) shouldBe false
    SecureContainer.withinRange(679128) shouldBe false
    SecureContainer.withinRange(371139) shouldBe true
  }

  behavior of "hasSameAdjacentDigits"

  it should "return true if the password contains two identical consecutive characters" in {
    SecureContainer.hasSameAdjacentDigits("012345") shouldBe false
    SecureContainer.hasSameAdjacentDigits("001234") shouldBe true
    SecureContainer.hasSameAdjacentDigits("011234") shouldBe true
    SecureContainer.hasSameAdjacentDigits("012234") shouldBe true
    SecureContainer.hasSameAdjacentDigits("012334") shouldBe true
    SecureContainer.hasSameAdjacentDigits("012344") shouldBe true
  }

  behavior of "hasIncrementingDigits"

  it should "return true if the digits do not decrease from beginning to end" in {
    SecureContainer.hasIncrementingDigits("012345") shouldBe true
    SecureContainer.hasIncrementingDigits("543210") shouldBe false
    SecureContainer.hasIncrementingDigits("012334") shouldBe true
  }

  behavior of "passwordMeetsCriteria"

  it should "return true if all the criteria have been met otherwise return false" in {
    SecureContainer.passwordMeetsCriteria("566789") shouldBe true
    SecureContainer.passwordMeetsCriteria("333333") shouldBe true
    SecureContainer.passwordMeetsCriteria("54321") shouldBe false
  }

  behavior of "findValidPassordsBetweenRanges"

  it should "return all the possible passwords between the ranges" in {
    val valids = SecureContainer.findValidPasswordsBetweenRanges()
    println(valids.size)
    println(valids)
  }


}
