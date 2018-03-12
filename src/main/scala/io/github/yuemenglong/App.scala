package io.github.yuemenglong

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */

import io.github.yuemenglong.auth.AuthService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.web.bind.annotation.{GetMapping, RestController}

object App {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[App])
    AuthService.login("admin", "admin")
  }
}

@SpringBootApplication
@EnableAutoConfiguration
@RestController
class App {
  @GetMapping(Array("/"))
  def index(): String = {
    "Index"
  }

  @GetMapping(Array("/login"))
  def login(name: String, password: String): String = {
    AuthService.login(name, password)
    "Login Succ"
  }

  @GetMapping(Array("/user"))
  def user: String = "User"
}


