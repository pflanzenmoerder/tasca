package de.codepitbull.tasca.service.task

import org.springframework.data.repository.CrudRepository
import de.codepitbull.tasca.entity.Task

trait TaskRepository extends CrudRepository[Task, String] with TaskRepositoryCustom
