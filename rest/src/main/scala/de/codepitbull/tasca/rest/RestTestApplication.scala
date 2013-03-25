package de.codepitbull.tasca.rest

import org.springframework.stereotype.Component
import org.restlet.Application
import org.restlet.routing.Router
import ressource.RootResource
import org.springframework.beans.factory.annotation.Autowired

@Component("application")
class RestTestApplication extends Application {

  @Autowired
  var fact: RestletFactory = _

  override def createInboundRoot() = {
    val apiRouter = new Router(getContext())
    apiRouter.attach("/", fact.createRestlet(classOf[RootResource]))
    apiRouter
  }
}
