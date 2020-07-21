package xyz.hyperreal._express

import typings.bodyParser.mod.OptionsJson

import scalajs.js
import typings.express.{mod => expressMod}
import typings.expressServeStaticCore.mod._
import typings.qs.mod.ParsedQs
import typings.cors.{mod => corsMod}
import typings.bodyParser.{mod => bodyParserMod}
import typings.compression.{mod => compressionMod}
import typings.helmet.{mod => helmetMod}

object Main extends App {

  val app = expressMod.^()
  val port = 8000

  app.use(corsMod.^())
  app.use(compressionMod.^())
  app.use(helmetMod.^())
  app.use(
    bodyParserMod
      .json(OptionsJson().setLimit("5mb").setStrict(false))
      .asInstanceOf[RequestHandler[ParamsDictionary, _, _, Query]])

  app.use[ParamsDictionary, js.Any, js.Any, ParsedQs]("/welcome".asInstanceOf[PathParams], WelcomeController.Router)

  app.listen(port, () => println(s"Listening at http://localhost:$port/"))

}

//  val requestHandler: RequestHandler[js.Dictionary[String], String, String, String] = (req, res, _) =>
//    res.send(s"name: ${req.params("name")}")

//  app.get[js.Dictionary[String], String, String, String]("/:name".asInstanceOf[PathParams], requestHandler)
