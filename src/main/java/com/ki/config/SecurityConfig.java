package com.ki.config;

//@Configuration
public class SecurityConfig {}
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserService userService;
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication().withUser("user@gmail.com").password("{noop}user").roles("user");
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/css/**", "/images/**", "/js/**", "/user/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .loginPage("/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//                        System.out.println(e.getLocalizedMessage());
//
//                        Enumeration<String> reqs = request.getAttributeNames();
//                        if (reqs.hasMoreElements()) {
//                            String key = reqs.nextElement();
//                            System.out.println(key + " : " + request.getAttribute(key));
//                        }
//                    }
//                })
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();
//    }
//
//
//}
