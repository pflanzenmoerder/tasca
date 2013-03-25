package de.codepitbull.tasca.service.tasklist

import javax.persistence.{EntityManager, PersistenceContext}
import de.codepitbull.tasca.entity.{QTaskList, User}
import com.mysema.query.jpa.impl.JPAQuery

class TaskListRepositoryImpl extends TaskListRepositoryCustom{
  @PersistenceContext
  var em: EntityManager = _

  val tasklist = QTaskList as "taskList"

  def findByUser(user: User) =
    jpaQuery from(tasklist) where(tasklist.owner eq user) list(QTaskList)

  def findByUserAndName(user:User, name: String) =
    jpaQuery from(QTaskList) where (tasklist.title like(name) and QTaskList.owner.eq(user)) list(QTaskList)

  def jpaQuery = new JPAQuery(em)
}
