package com.vinctus._express.error

import scala.scalajs.js

abstract class HttpError(val errorCode: String) extends js.Error(errorCode) {
  val statusCode: Int
}

class BadRequest(errorCode: String) extends HttpError(errorCode) { val statusCode = 400 }

class NotAuthenticated(errorCode: String) extends HttpError(errorCode) { val statusCode = 401 }

class Forbidden(errorCode: String) extends HttpError(errorCode) { val statusCode = 403 }

class NotFound(errorCode: String) extends HttpError(errorCode) { val statusCode = 404 }

class Conflict(errorCode: String) extends HttpError(errorCode) { val statusCode = 409 }

class TeaPot(errorCode: String) extends HttpError(errorCode) { val statusCode = 418 }

class Unprocessable(errorCode: String) extends HttpError(errorCode) { val statusCode = 422 }

class GeneralError(errorCode: String) extends HttpError(errorCode) { val statusCode = 500 }
