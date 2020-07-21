package xyz.hyperreal._express

import scalajs.js

import typings.express.{mod => expressMod}
import typings.expressServeStaticCore.mod._

object WelcomeController {

  val Router: Router = expressMod.Router()

  val Index: RequestHandler[Unit, String, Unit, Unit] =
    (req, res, next) => res.send("Hello, World!")

  trait HasName extends js.Object {
    val name: js.UndefOr[String]
  }

  val Name: RequestHandler[HasName, String, Unit, Unit] = (req, res, next) =>
    res.send(s"Hello, ${req.params.name.getOrElse("No Name")}!")

  Router
    .get[Unit, String, Unit, Unit]("/", Index)
    .get[HasName, String, Unit, Unit]("/:name", Name)

}
