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
import de.codepitbull.tasca.entity.Task
import de.codepitbull.tasca.service.user.UserRepository
import de.codepitbull.tasca.service.tasklist.TaskListRepository
import javax.persistence.{EntityManager, PersistenceContext}

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array { "classpath:./applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
class TaskRepositoryIT {

  @PersistenceContext
  var em: EntityManager = _

  @Autowired
  var taskRepository: TaskRepository = _

  @Autowired
  var userRepository: UserRepository = _

  @Autowired
  var taskListRepository: TaskListRepository = _

  @Test
  def testFindAll() {
    assertEquals(3,taskRepository.findAll().size)
  }

  @Test
  def testFindOne() {
    assertNotNull(taskRepository.findOne("task1"))
  }

  @Test
  def testFindByUser() {
    val user = userRepository.findOne("user1")
    assertEquals(3, taskRepository.findByUser(user).size())
  }

  @Test
  def testFindByUserAndName() {
    val user = userRepository.findOne("user1")
    assertEquals(3, taskRepository.findByUserAndName(user, "task%").size())
  }

  @Test
  def testFindFindByUserAndNotInTaskList() {
    val user = userRepository.findOne("user1")
    assertEquals(2, taskRepository.findFindByUserAndNotInTaskList(user).size())
  }

  @Test
  def testFindByTaskList() {
    val taskList = taskListRepository.findOne("taskList1")
    assertNotNull(taskRepository.findByTaskList(taskList))
  }

  @Test
  def testSaveWithTaskList() {
    val user = userRepository.findOne("writeUser")
    val taskList = taskListRepository.findOne("testList2")
    val task = new Task();
    task.setDueDate(null);
    task.setFinishedDate(null);
    task.setName("saveTask");
    task.setOwner(user)
    task.setTaskList(taskList)
    assertNotNull(taskRepository.save(task))
  }

  @Test
  def testSaveWithoutTaskList() {
    val user = userRepository.findOne("writeUser")
    val task = new Task();
    task.setDueDate(null);
    task.setFinishedDate(null);
    task.setName("saveTask");
    task.setOwner(user)
    assertNotNull(taskRepository.save(task))
    em.flush()
  }

}
