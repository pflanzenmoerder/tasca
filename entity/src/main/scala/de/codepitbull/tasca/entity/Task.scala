package de.codepitbull.tasca.entity

import javax.persistence._
import java.util.Date
import reflect.BeanProperty

@Entity
@Table(name = "TS_TASK")
class Task extends BaseEntity{

  @BeanProperty
  @ManyToOne(optional = false)
  @JoinColumn(name = "OWNER_ID")
  var owner: User = _

  @BeanProperty
  @ManyToOne
  @JoinColumn(name = "TASK_LIST_ID")
  var taskList: TaskList = _

  @BeanProperty
  @Column(name = "NAME", nullable = false)
  var name: String = _

  @BeanProperty
  @Column(name = "DUEDATE")
  var dueDate: Date = _

  @BeanProperty
  @Column(name = "FINISHEDDATE")
  var finishedDate: Date = _
}
