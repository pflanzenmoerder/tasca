package de.codepitbull.tasca.service.user

import de.codepitbull.tasca.entity.User

/**
 *
 * @author Jochen Mader
 */
trait UserRepositoryCustom {
  def findByName(name: String): User

  def findByNameAndPassword(name: String, password: String): User
}
