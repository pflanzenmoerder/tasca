package de.codepitbull.tasca.rest

import org.springframework.beans.factory.{BeanFactory, BeanFactoryAware}
import org.springframework.stereotype.Component
import org.restlet.resource.ServerResource

@Component
class RestletFactory extends BeanFactoryAware {

  var beanFactory: BeanFactory = _;

  def createRestlet(clazz: Class[_ <: ServerResource]) = {
    val restlet = new SpringRestlet
    restlet.beanFactory = beanFactory
    restlet.clazz = clazz
    restlet
  }

  def setBeanFactory(beanFactory: BeanFactory) {
    this.beanFactory = beanFactory
  }
}
