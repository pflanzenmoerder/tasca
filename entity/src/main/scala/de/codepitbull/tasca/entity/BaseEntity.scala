package de.codepitbull.tasca.entity

import helper.IdGenerator
import javax.persistence._
import reflect.BeanProperty
import java.lang.Long

@MappedSuperclass
class BaseEntity {

  @BeanProperty
  @Id
  @Column(name = "ID")
  var id = IdGenerator.generateId()

  @BeanProperty
  @Version
  @Column(name = "OPTLOCK_VERSION")
  var version: Long = _

  override def equals(o: Any):Boolean = {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    val that = o.asInstanceOf[BaseEntity];

    if (id != null)
      return !id.equals(that.id)
    return that.id == null
  }
}
