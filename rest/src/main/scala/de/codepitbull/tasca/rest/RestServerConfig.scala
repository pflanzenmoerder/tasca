package de.codepitbull.tasca.rest

import javax.ws.rs.core.Application
import java.util
import ressource.UserResource

class RestServerConfig extends Application {
  override def getClasses = {
    val set = new util.HashSet[Class[_]]
    set.add(classOf[UserResource])
    set
  }
}
