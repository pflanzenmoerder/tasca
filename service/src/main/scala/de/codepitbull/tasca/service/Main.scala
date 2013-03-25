package de.codepitbull.tasca.service

import org.springframework.context.support.ClassPathXmlApplicationContext
import task.TaskRepository
import user.UserRepository
import de.codepitbull.tasca.entity.User
import collection.JavaConversions.iterableAsScalaIterable

object Main {
  def main(args: Array[String]) {
    val ctx = new ClassPathXmlApplicationContext("applicationContext.xml")
    ctx.start()
    val taskRepo:TaskRepository = ctx.getBean(classOf[TaskRepository])
    println(taskRepo.findAll().size)
    readByte()
  }
}
