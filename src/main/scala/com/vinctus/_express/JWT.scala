package com.vinctus._express

import typings.jsonwebtoken.mod.{Algorithm, SignOptions, VerifyOptions}
import typings.jsonwebtoken.{mod => jwt}

import scala.scalajs.js

object JWT {
  val JWT_SECRET = "7cD6ig5qjfzvV23b4XxczGTWB9wa9GZ3UiRFvDXjnkHzVKckn2PVbSEP6sZGkjbR"

  def generateToken(id: Int): String =
    jwt.sign(js.Dynamic.literal(id = id),
             JWT_SECRET,
             SignOptions().setExpiresIn("30 days").setSubject(id.toString).setAlgorithm(Algorithm.HS512))

  def verifyToken(token: String): Option[Int] =
    try {
      val decoded =
        jwt.verify(token, JWT_SECRET, VerifyOptions().setAlgorithms(js.Array(Algorithm.HS512)))

      if (js.typeOf(decoded) == "object" && decoded.asInstanceOf[js.Object].hasOwnProperty("sub"))
        Some(decoded.asInstanceOf[js.Dictionary[String]]("sub").toInt)
      else
        None
    } catch {
      case _: Exception => None
    }
}
