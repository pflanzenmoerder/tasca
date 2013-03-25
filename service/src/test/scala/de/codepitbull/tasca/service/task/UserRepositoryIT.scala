package de.codepitbull.tasca.service.task

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Test
import org.junit.Assert._
import collection.JavaConversions.iterableAsScalaIterable
import de.codepitbull.tasca.entity.{User, Task}
import de.codepitbull.tasca.service.user.UserRepository
import de.codepitbull.tasca.service.tasklist.TaskListRepository
import javax.persistence.{EntityManager, PersistenceContext}

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array { "classpath:./applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
class UserRepositoryIT {

  @PersistenceContext
  var em: EntityManager = _

  @Autowired
  var userRepository: UserRepository = _

  @Test
  def testFindAll() {
    assertEquals(3,userRepository.findAll().size)
  }

  @Test
  def testFindOne() {
    assertNotNull(userRepository.findOne("user1"))
  }

  @Test
  def testFindByName() {
    assertNotNull(userRepository.findByName("user1"))
  }

  @Test
  def testFindByNameAndPassword() {
    assertNotNull(userRepository.findByNameAndPassword("user1", "testPass"))
  }

  @Test
  def testSave() {
    val user = new User()
    user.setName("testSave")
    user.setPassword("pass")
    user.setSalt("salt")
    assertNotNull(userRepository.findByName("user1"))
    em.flush()
  }

}
