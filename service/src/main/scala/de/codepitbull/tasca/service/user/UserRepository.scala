package de.codepitbull.tasca.service.user

import de.codepitbull.tasca.entity.User
import org.springframework.data.repository.CrudRepository

trait UserRepository extends CrudRepository[User, String] with UserRepositoryCustom
