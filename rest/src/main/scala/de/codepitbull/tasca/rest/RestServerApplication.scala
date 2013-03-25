package de.codepitbull.tasca.rest

import org.restlet.ext.jaxrs.{ObjectFactory, JaxRsApplication}
import org.springframework.beans.factory.{BeanFactory, BeanFactoryAware, InitializingBean}
import org.springframework.beans.factory.annotation.{Qualifier, Autowired}
import org.restlet.Component
import org.springframework.stereotype

//@stereotype.Component
class RestServerApplication extends JaxRsApplication with InitializingBean with BeanFactoryAware{
  @Autowired
//  @Qualifier("restletComponent")
  var component:Component = _;

  def afterPropertiesSet() {
    setContext(component.getContext.createChildContext())
    add(new RestServerConfig)
    component.getDefaultHost.attach(this)
  }

  def setBeanFactory(beanFactory: BeanFactory) {
    setObjectFactory(new ObjectFactory {
      def getInstance[T](jaxRsClass: Class[T]) = beanFactory.getBean(jaxRsClass)
    })
  }
}
