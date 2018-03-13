package io.github.yuemenglong.auth

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.core.userdetails.UserDetailsService

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
  override def userDetailsService(): UserDetailsService = new UserDetailsServiceImpl()

}
