package actions

import scala.concurrent.Future
import scala.util.{Failure, Success}
import play.api.mvc.{Result, Request, ActionBuilder}
import play.api.Logger

object LoggingAction extends ActionBuilder[Request] {

  import scala.concurrent.ExecutionContext.Implicits.global

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    val now = System.currentTimeMillis()
    Logger.info("Start action")
    val result = block(request)
    result.andThen {
      case Success(r) =>
        Logger.info(s"End action\nDuration: ${System.currentTimeMillis()-now}, Result: ${r.toString}")
      case Failure(t) =>
        Logger.info(s"Failed action\nDuration: ${System.currentTimeMillis()-now}, Result: ${t.getMessage}")
    }
  }
}