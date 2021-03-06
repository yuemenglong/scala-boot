package io.github.yuemenglong

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */

import javax.servlet.http.HttpServletRequest

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
@RestController
class App {
  @GetMapping(Array("/login"))
  def login(name: String, password: String): Unit = {
    AuthService.login(name, password)
  }

  @GetMapping(Array("/logout"))
  def logout(request: HttpServletRequest): Unit = {
    request.logout()
  }

  @GetMapping(Array("/**"))
  def index(): Unit = {}
}


