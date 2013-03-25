package de.codepitbull.tasca.service.task

import de.codepitbull.tasca.entity.{User, TaskList, Task}
import java.util

trait TaskRepositoryCustom {
  def findByUserAndName(user:User, name: String): util.List[Task]
  def findByTaskList(taskList: TaskList): util.List[Task]
  def findByUser(user: User): util.List[Task]
  def findFindByUserAndNotInTaskList(user: User): util.List[Task]
}
