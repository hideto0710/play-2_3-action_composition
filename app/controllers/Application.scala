package controllers

import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import actions.LoggingAction

object Application extends Controller {

  def index = Action {
    Ok(Json.toJson(Map("status" -> "ok!")))
  }

  def id(id: Int) = LoggingAction.async { request =>
    import scala.concurrent.ExecutionContext.Implicits.global
    Future {
      Thread.sleep(100)
      Ok(Json.toJson(Map("id" -> id)))
    }
  }

  def idStr(id: String) = LoggingAction { request =>
    Ok(Json.toJson(Map("id" -> id)))
  }
}