package io.github.yuemenglong.auth

import java.util

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.BadCredentialsException

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */
case class UserIdentity(name: String, password: String)

object AuthService {
  def login(name: String, password: String): Unit = {
    //    val r = s"ROLE_${role}"
    //    val list: util.List[SimpleGrantedAuthority] = util.Arrays.asList(new SimpleGrantedAuthority(s"ROLE_${role}"))
    val request = new UsernamePasswordAuthenticationToken(name, password)
    val result = request.getName == request.getCredentials match {
      case true => new UsernamePasswordAuthenticationToken(request.getName, request.getCredentials)
      case false => throw new BadCredentialsException("Bad Credentials")
    }
    SecurityContextHolder.getContext.setAuthentication(result)
  }
}
