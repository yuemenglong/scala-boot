package io.github.yuemenglong.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.{InMemoryUserDetailsManager, UserDetailsManager}

/**
  * Created by <yuemenglong@126.com> on 2018/3/12.
  */
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

  override protected def configure(http: HttpSecurity): Unit = {
    http.csrf().disable()
      .authorizeRequests
      .antMatchers("/index", "/login", "/logout").permitAll()
      .antMatchers("/user/**").hasRole("USER")
      .anyRequest().authenticated()
  }

  @Bean
  override def userDetailsService(): UserDetailsManager = {
    val manager = new InMemoryUserDetailsManager()
    manager.createUser(User.withUsername("user").password("password").roles("USER").build)
    manager.createUser(User.withUsername("admin").password("admin").roles("USER", "ADMIN").build)
    manager
  }
}
