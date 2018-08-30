package playground.frontend

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.http.path.Root
import com.twitter.finagle.{Http, Service}
import com.twitter.util.{Future, Return}
import io.fintrospect.RouteModule
import io.fintrospect.formats.Circe
import playground.common.api.Frontend._

object AppStarter extends App {
  val svc = Service.mk[Request, Response] { request =>
    val x = requestBodySpec <-- request
    Future.const(Return(ApiResponse(PetInfo("", 0, ""), OwnerInfo("", 0))))
  }


  Http.serve(":8080", RouteModule(Root).withRoute(bindRoute).toService)
}
