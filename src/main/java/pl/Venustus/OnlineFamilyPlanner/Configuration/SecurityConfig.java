
package pl.Venustus.OnlineFamilyPlanner.Configuration;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig
// extends WebSecurityConfigurerAdapter
{
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}1986")
//                .roles("USER", "ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/images**", "/", "/login**")
//                .permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/h2/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }

}
