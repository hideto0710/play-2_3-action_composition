import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "return the index json" in new WithApplication{
      val index = route(FakeRequest(GET, "/")).get
      status(index) must equalTo(OK)
      contentType(index) must beSome.which(_ == "application/json")
      contentAsString(index) must contain ("ok!")
    }
  }
}
