package de.codepitbull.tasca.rest.ressource

import javax.ws.rs._
import javax.ws.rs.core._
import scala.Array
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import de.codepitbull.tasca.service.user.UserRepository

@Path("/user")
@Component
class UserResource() {

  @Autowired
  var userRepository:UserRepository = _

  @Context
  var uriInfo:UriInfo = _

  @GET
  @Produces(value = Array(MediaType.TEXT_PLAIN))
  @Path("/{username}")
  def getUserByName(@PathParam("username") username: String):String = {
    val user = userRepository.findByName(username)
    if (user != null)
      user.getName
    else
      throw new WebApplicationException(404)
  }

  @GET
  @Produces(value = Array(MediaType.TEXT_HTML))
  @Path("/")
  def getStuff():String = {
    val str = "value"
    val span = <form method="POST">
      <input type="text" name="name"/>
      <input type="submit" value="sub"/>
    </form>
    span.toString
  }

  @POST
  @Produces(value = Array(MediaType.TEXT_HTML))
  @Path("/")
  def postStuff(@FormParam("name") name:String) = {
    println("waha "+name)
//    Response.status(200)
//      .entity("addUser is called, name : " + name)
//      .build();

    Response.created(uriInfo.getAbsolutePath()).build()
  }
}
