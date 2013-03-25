package de.codepitbull.tasca.service.user

import javax.persistence.{EntityManager, PersistenceContext}
import com.mysema.query.jpa.impl.JPAQuery
import de.codepitbull.tasca.entity.QUser

class UserRepositoryImpl extends UserRepositoryCustom{
  @PersistenceContext
  var em: EntityManager = _

  val user = QUser as "user"

  def findByName(name: String) =
    jpaQuery from(user) where user.name.eq(name) uniqueResult(user)


  def findByNameAndPassword(name: String, password: String) =
    jpaQuery from(user) where(user.name.eq(name) and user.password.eq(password)) singleResult(user)

  def jpaQuery = new JPAQuery(em)

}
