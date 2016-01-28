package actions

import play.api.mvc.{ActionBuilder, Request, Result}
import scala.concurrent.Future

case class User(name: String)
case class UserRequest[A](val user: User, r: Request[A]) extends Request[A] {
  override def id = r.id
  override def tags = r.tags
  override def uri = r.uri
  override def path = r.path
  override def method = r.method
  override def version = r.version
  override def queryString = r.queryString
  override def headers = r.headers
  override def secure = r.secure
  override lazy val remoteAddress = r.remoteAddress
  override val body = r.body
}

object UserAction extends ActionBuilder[UserRequest] {

  def invokeBlock[A](request: Request[A], block: (UserRequest[A]) => Future[Result]) = {
    block(UserRequest(User("mike"), request))
  }
}