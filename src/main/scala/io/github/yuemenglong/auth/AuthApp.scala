/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */
package io.github.yuemenglong.auth

import javax.servlet.http.HttpServletRequest
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{GetMapping, RestController}

object AuthApp {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[AuthApp])
    AuthService.login("admin", "admin")
  }
}

@SpringBootApplication
@RestController
class AuthApp {
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


