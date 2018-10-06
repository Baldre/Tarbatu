package ee.ut.cs.wad2018.tarbatu;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll();
*/
        http
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error.html")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }
}