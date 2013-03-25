package de.codepitbull.tasca.service.tasklist

import org.springframework.data.repository.CrudRepository
import de.codepitbull.tasca.entity.TaskList

trait TaskListRepository extends CrudRepository[TaskList, String] with TaskListRepositoryCustom
