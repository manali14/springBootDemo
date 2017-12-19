package com.airtel.config;

//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.airtel")
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/login*//**").permitAll()
     .antMatchers("/login/welcome").permitAll()
     .antMatchers("/login/homePage").permitAll()
     .antMatchers("/login/signUp").permitAll()
     .antMatchers("/user*//**").permitAll()
     //                .antMatchers("/admin*//**").access("hasRole('ROLE_ADMIN')")
     //                .antMatchers("/user*//**").access("hasRole('ROLE_USER')")
     .and()
     .formLogin().loginPage("/login/signIn").failureUrl("/login/signIn?error").defaultSuccessUrl("/user/dashboard")
     .usernameParameter("username").passwordParameter("password")
     .and()
     .logout().logoutSuccessUrl("/login/signIn?logout")
     .and()
     .exceptionHandling().accessDeniedPage("/403")
     .and()
     .csrf();
     }*/
}
