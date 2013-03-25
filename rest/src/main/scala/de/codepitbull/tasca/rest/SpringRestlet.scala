package de.codepitbull.tasca.rest

import org.restlet.{Response, Request, Restlet}
import org.springframework.beans.factory.{BeanFactory, InitializingBean, BeanFactoryAware}
import org.restlet.resource.ServerResource
import ressource.RootResource

class SpringRestlet extends Restlet{

  var beanFactory: BeanFactory = _

  var clazz:Class[_ <: ServerResource] = _

  override def handle(request: Request, response: Response) {
    val targetResource = beanFactory.getBean(clazz)
    targetResource.init(getContext(), request, response);

    if ((response == null) || response.getStatus().isSuccess()) {
      targetResource.handle();
    } else {
      // Probably during the instantiation of the target
      // server resource, or earlier the status was
      // changed from the default one. Don't go further.
    }

    targetResource.release();
  }
}
