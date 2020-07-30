package com.vinctus._express

import scalajs.js
import typings.bodyParser.mod.OptionsJson
import typings.express.{mod => expressMod}
import typings.expressServeStaticCore.mod._
import typings.qs.mod.ParsedQs
import typings.cors.{mod => corsMod}
import typings.bodyParser.{mod => bodyParserMod}
import typings.compression.{mod => compressionMod}
import typings.helmet.{mod => helmetMod}
import typings.pg.mod.types.setTypeParser

object Main extends App {

  setTypeParser(20, (s: Any) => s.asInstanceOf[String].toDouble)

  val app = expressMod.^()
  val port = 8000

  app.use(corsMod.^())
  app.use(compressionMod.^())
  app.use(helmetMod.^())
  app.use(
    bodyParserMod
      .json(OptionsJson().setLimit("5mb").setStrict(false))
      .asInstanceOf[RequestHandler[ParamsDictionary, _, _, Query]])

  app.use[ParamsDictionary, js.Any, js.Any, ParsedQs]("/welcome", controller.Welcome.router)
  app.use[ParamsDictionary, js.Any, js.Any, ParsedQs]("/auth", controller.Auth.router)

  val errorHandler: ErrorRequestHandler[ParamsDictionary, js.Any, js.Any, ParsedQs] =
    (err, req, res, _) => {
      println(err)
      res.status(500).send("server error")
    }

  app.use(errorHandler.asInstanceOf[RequestHandlerParams[ParamsDictionary, js.Any, js.Any, ParsedQs]])

  app.listen(port, () => println(s"Listening at http://localhost:$port/"))

}
