package com.vinctus._express.controller

import com.vinctus._express.error.{ErrorCode, NotAuthenticated, NotFound}
import com.vinctus._express.service.JWT
import typings.express.mod.Router
import typings.expressServeStaticCore.mod.{RequestHandler, Router}

import scala.scalajs.js

object Auth {

  case class AdminAccount(
      id: Int,
      email: String,
      password: String
  )

  val adminAccounts: List[AdminAccount] =
    List(
      AdminAccount(1, "user@example.com", "the-password")
    )

  val router: Router = Router()

  trait LoginReqBody extends js.Object {
    val email: String
    val password: String
  }

  class TokenResBody(val token: String) extends js.Object

  private val authenticate: RequestHandler[Unit, TokenResBody, LoginReqBody, Unit] =
    (req, res, next) =>
      try {
        adminAccounts.find(_.email == req.body.email) match {
          case Some(value) =>
            if (value.password != req.body.password)
              next(new NotAuthenticated(ErrorCode.LOGIN_BAD_CREDENTIALS))
            else
              res.json(new TokenResBody(JWT.generateToken(value.id)))
          case None => next(new NotFound(ErrorCode.USER_NOT_FOUND))
        }
      } catch {
        case e: Exception =>
          next(e.getMessage)
    }

  trait ResLocals extends js.Object {
    var userId: Int
  }

  private val refresh: RequestHandler[Unit, TokenResBody, Unit, Unit] =
    (_, res, next) => {
      try {
        res.json(new TokenResBody(JWT.generateToken(res.locals.asInstanceOf[ResLocals].userId)))
      } catch {
        case e: Exception =>
          next(e.getMessage)
      }
    }

  private val authenticated: RequestHandler[Unit, TokenResBody, Unit, Unit] =
    (req, res, next) => {
      val authHeader = req.header("authorization")

      if (authHeader.isEmpty || !authHeader.get.startsWith("Bearer "))
        next(new NotAuthenticated(ErrorCode.UNAUTHORIZED))
      else {
        val token = authHeader.get.split(" ")(1)
        val userId = JWT.verifyToken(token)

        if (userId.isEmpty) {
          next(new NotAuthenticated(ErrorCode.UNAUTHORIZED))
        } else {
          res.locals.asInstanceOf[ResLocals].userId = userId.get
          next()
        }
      }
    }

  router
    .post[Unit, TokenResBody, LoginReqBody, Unit]("/login", authenticate)
    .get[Unit, TokenResBody, Unit, Unit]("/refresh", authenticated, refresh)

}
