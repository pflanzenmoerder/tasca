package de.codepitbull.tasca.service.tasklist

import de.codepitbull.tasca.entity.{TaskList, User}
import java.util

trait TaskListRepositoryCustom {
  def findByUser(user: User): util.List[TaskList]
  def findByUserAndName(user: User, name: String): util.List[TaskList]
}
