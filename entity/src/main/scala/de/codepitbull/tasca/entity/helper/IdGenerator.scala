package de.codepitbull.tasca.entity.helper

import java.util.UUID

/**
 *
 * @author Jochen Mader
 */
object IdGenerator {
  def generateId() = {
    UUID.randomUUID().toString
  }
}
