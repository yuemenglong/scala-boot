package io.github.yuemenglong.auth

import java.util

import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService, UsernameNotFoundException}
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */

class UserDetailsServiceImpl extends UserDetailsService {

  override def loadUserByUsername(username: String): UserDetails = {
    new UserDetails {
      override def isAccountNonLocked = true

      override def getAuthorities = new util.ArrayList()

      override def getUsername = username

      override def getPassword = username

      override def isCredentialsNonExpired = true

      override def isAccountNonExpired = true

      override def isEnabled = true
    }
  }
}
