package de.codepitbull.tasca.service.task

import javax.persistence.{EntityManager, PersistenceContext}
import  de.codepitbull.tasca.entity.{QTask, TaskList, User}
import com.mysema.query.jpa.impl.JPAQuery

class TaskRepositoryImpl extends TaskRepositoryCustom{
  @PersistenceContext
  var em: EntityManager = _

  def findByUserAndName(user: User, name: String) =
    jpaQuery from QTask where (QTask.owner.eq(user) and QTask.name.like(name)) list(QTask)

  def findByTaskList(taskList: TaskList) =
    jpaQuery from(QTask) where QTask.taskList.eq(taskList) list(QTask)

  def findByUser(user: User) =
    jpaQuery from QTask where QTask.owner.eq(user) list(QTask)

  def findFindByUserAndNotInTaskList(user: User) =
    jpaQuery from QTask where (QTask.owner.eq(user) and QTask.taskList.isNull) list(QTask)

  def jpaQuery = new JPAQuery(em)
}
