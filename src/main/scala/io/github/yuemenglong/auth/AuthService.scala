package io.github.yuemenglong.auth

import java.util

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.provisioning.InMemoryUserDetailsManager

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */
case class UserIdentity(name: String, password: String)

object AuthService {
  val manager = new InMemoryUserDetailsManager

  def login(name: String, password: String, role: Set[String] = null): Unit = {
    val request = new UsernamePasswordAuthenticationToken(name, password)
    val result = request.getName == request.getCredentials match {
      case true => new UsernamePasswordAuthenticationToken(request.getName, request.getCredentials)
      case false => throw new BadCredentialsException("Bad Credentials")
    }
    if (role != null) {
      var set = Set[String]()
      result.getAuthorities.iterator().forEachRemaining(o => set += o.getAuthority)
      if (role.intersect(set).isEmpty) {
        throw new BadCredentialsException("Role Not Match")
      }
    }
    SecurityContextHolder.getContext.setAuthentication(result)
  }
}
