package playground.common.api

import com.twitter.finagle.http._
import io.circe.generic.auto._
import io.fintrospect.formats._
import io.fintrospect.parameters.Body
import io.fintrospect.{ContentTypes, ResponseSpec, RouteSpec}

object Frontend {

  case class ApiRequest(petType: String, petName: String)

  case class ApiResponse(petInfo: PetInfo, hostInfo: OwnerInfo)

  case class PetInfo(name: String, age: Int, preferredFood: String)

  case class OwnerInfo(name: String, age: Int)

  val requestBodySpec = Body.of(
    description = "",
    example = ApiRequest("dog", "Woffie"),
    bodySpec = Circe.bodySpec[ApiRequest]
  )

  val responseSpec =
    ResponseSpec(
      statusAndDescription = (Status.Ok, "Successful response including info about pet and its owner"),
      example = ApiResponse(PetInfo("Woffie", 5, "apple"), OwnerInfo("Jack", 19)),
      bodySpec = Circe.bodySpec[ApiResponse]
    )

  val route =
    RouteSpec("Returns verbose info for given pet type and pet name")
      .consuming(ContentTypes.APPLICATION_JSON)
      .body(requestBodySpec)
      .returning(responseSpec)
      .at(Method.Post) / "pet_info"
}
