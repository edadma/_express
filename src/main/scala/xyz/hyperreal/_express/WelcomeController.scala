package xyz.hyperreal._express

import scalajs.js

import typings.express.{mod => expressMod}
import typings.expressServeStaticCore.mod._

object WelcomeController {

  val router: Router = expressMod.Router()

  private val index: RequestHandler[Unit, String, Unit, Unit] =
    (req, res, next) => res.send("Hello, World!")

  trait HasName extends js.Object {
    val name: js.UndefOr[String]
  }

  private val name: RequestHandler[HasName, String, Unit, Unit] = (req, res, next) =>
    res.send(s"Hello, ${req.params.name.getOrElse("No Name")}!")

  router
    .get[Unit, String, Unit, Unit]("/", index)
    .get[HasName, String, Unit, Unit]("/:name", name)

}
