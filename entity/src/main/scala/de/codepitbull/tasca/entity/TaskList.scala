package de.codepitbull.tasca.entity

import javax.persistence._
import reflect.BeanProperty

@Entity
@Table(name = "TS_TASK_LIST")
class TaskList extends BaseEntity{
  @BeanProperty
  @Column(name = "TITLE", nullable = false)
  var title: String = _

  @BeanProperty
  @ManyToOne(optional = false)
  @JoinColumn(name = "USER_ID")
  var owner: User = _
}
