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
import de.codepitbull.tasca.entity.{TaskList, User}
import de.codepitbull.tasca.service.user.UserRepository
import de.codepitbull.tasca.service.tasklist.TaskListRepository
import javax.persistence.{EntityManager, PersistenceContext}

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array { "classpath:./applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
class TaskListRepositoryIT {

  @PersistenceContext
  var em: EntityManager = _

  @Autowired
  var taskListRepository: TaskListRepository = _

  @Autowired
  var userRepository: UserRepository = _

  @Test
  def testFindAll() {
    assertEquals(2,taskListRepository.findAll().size)
  }

  @Test
  def testFindOne() {
    assertNotNull(taskListRepository.findOne("taskList1"))
  }

  @Test
  def testFindByUserAndName() {
    val user = userRepository.findOne("user1")
    assertNotNull(taskListRepository.findByUserAndName(user, "testList"))
  }

  @Test
  def testSave() {
    val user = userRepository.findOne("user1")
    val taskList = new TaskList
    taskList.setOwner(user)
    taskList.setTitle("task list")
    taskListRepository.save(taskList)
    em.flush()
  }

}
