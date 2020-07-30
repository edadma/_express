package com.vinctus._express.controller

import typings.express.mod.Router
import typings.expressServeStaticCore.mod.{RequestHandler, Router}

import scala.scalajs.js

object Welcome {

  val router: Router = Router()

  private val index: RequestHandler[Unit, String, Unit, Unit] =
    (_, res, _) => res.send("Hello, World!")

  trait HasName extends js.Object {
    val name: js.UndefOr[String]
  }

  private val getName: RequestHandler[HasName, String, Unit, Unit] = (req, res, _) =>
    res.send(s"Hello ${req.params.name.get}")

  private val getId: RequestHandler[js.Dictionary[String], String, Unit, Unit] = (req, res, _) =>
    res.send(s"ID: ${req.params get "id" getOrElse "No ID"}!")

  router
    .get[Unit, String, Unit, Unit]("/", index)
    .get[HasName, String, Unit, Unit]("/name/:name", getName)
    .get[js.Dictionary[String], String, Unit, Unit]("/id/:id", getId)

}
