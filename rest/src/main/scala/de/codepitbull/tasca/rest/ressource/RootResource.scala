package de.codepitbull.tasca.rest.ressource

import org.restlet.resource.{Get, ServerResource}
import org.restlet.representation.StringRepresentation
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope
import org.springframework.beans.factory.config.ConfigurableBeanFactory

@Component("rootResource")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class RootResource extends ServerResource {

  @Get
  def represent() = {
    new StringRepresentation("'This is: " + getApplication().getName() + "'");
  }
}
