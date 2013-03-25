package de.codepitbull.tasca.entity

import javax.persistence.{Entity, Column, Table}
import reflect.BeanProperty

@Entity
@Table(name = "TS_USER")
class User extends BaseEntity{

  @BeanProperty
  @Column(name = "PASSWORD", nullable = false)
  var password: String = _

  @BeanProperty
  @Column(name = "SALT", nullable = false)
  var salt: String = _

  @BeanProperty
  @Column(name = "NAME", nullable = false, unique = true)
  var name: String = _
}
