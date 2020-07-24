package com.vinctus._express

object ErrorCode {

  /* General System Errors*/
  val GENERAL = "GENERAL"
  val SERVER_ERROR = "SERVER_ERROR"
  val UNAUTHORIZED = "UNAUTHORIZED"

  //Validation
  val INPUT_VALIDATION_FAILED = "INPUT_VALIDATION_FAILED"

  //Protocol Errors
  val ACCESS_DENIED = "ACCESS_DENIED"
  val HTTP_MESSAGE_NOT_READABLE = "HTTP_MESSAGE_NOT_READABLE"

  /* Authentication */
  //Register
  val REGISTER_EMAIL_IN_USE = "REGISTER_EMAIL_IN_USE"
  val REGISTER_EMAIL_DISABLED = "REGISTER_EMAIL_DISABLED"
  val REGISTER_OWNER_ALREADY_EXISTS = "REGISTER_OWNER_ALREADY_EXISTS"

  //Login
  val LOGIN_BAD_CREDENTIALS = "LOGIN_BAD_CREDENTIALS"
  val LOGIN_ACCOUNT_DISABLED = "LOGIN_ACCOUNT_DISABLED"
  val LOGIN_ACCOUNT_LOCKED = "LOGIN_ACCOUNT_LOCKED"
  val LOGIN_ACCOUNT_TYPE_NOT_SUPPORTED = "LOGIN_ACCOUNT_TYPE_NOT_SUPPORTED"

  /* Email Templates */
  val EMAIL_TEMPLATE_INVALID_KEY = "EMAIL_TEMPLATE_INVALID_KEY"

  /* User */
  val USER_NOT_FOUND = "USER_NOT_FOUND"

  //Account Access
  val USER_ACCOUNT_INACTIVE = "USER_ACCOUNT_INACTIVE"

  //User Update
  val USER_UPDATE_LAST_ADMIN = "USER_UPDATE_LAST_ADMIN"
  val USER_UPDATE_MUST_HAVE_STATION = "USER_UPDATE_MUST_HAVE_STATION"
  val USER_UPDATE_OWN_ACCOUNT_STATE = "USER_UPDATE_OWN_ACCOUNT_STATE"

  //User Delete
  val USER_DELETE_SELF = "USER_DELETE_SELF"
  val USER_DELETE_LAST_EXISTING = "USER_DELETE_LAST_EXISTING"
  val USER_DELETE_LAST_ADMIN = "USER_DELETE_LAST_ADMIN"

  /* Resources */
  val RESOURCE_INVALID_TYPE = "RESOURCE_INVALID_TYPE"
  val RESOURCE_INVALID_FORMAT = "RESOURCE_INVALID_FORMAT"
  val RESOURCE_UPLOAD_FAILED = "RESOURCE_UPLOAD_FAILED"

}
