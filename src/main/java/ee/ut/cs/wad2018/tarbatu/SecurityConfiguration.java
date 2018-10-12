package ee.ut.cs.wad2018.tarbatu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@EnableOAuth2Sso
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private OAuth2ClientContext oAuth2ClientContext;
    private AuthorizationCodeResourceDetails authorizationCodeResourceDetails;
    private ResourceServerProperties resourceServerProperties;

    @Autowired
    @Qualifier("oauth2ClientContext")
    public void setOAuth2ClientContext(OAuth2ClientContext oAuth2ClientContext){
        this.oAuth2ClientContext = oAuth2ClientContext;
    }

    @Autowired
    public void setAuthorizationCodeResourceDetails(AuthorizationCodeResourceDetails authorizationCodeResourceDetails){
        this.authorizationCodeResourceDetails = authorizationCodeResourceDetails;
    }

    @Autowired
    public void setResourceServerProperties(ResourceServerProperties resourceServerProperties) {
        this.resourceServerProperties = resourceServerProperties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user").authenticated()
                .antMatchers("/**").permitAll()
                .and().addFilterAt(filter(), BasicAuthenticationFilter.class)
                .logout().logoutSuccessUrl("/");
        /*       http
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");*/
    }

    private OAuth2ClientAuthenticationProcessingFilter filter(){
        OAuth2ClientAuthenticationProcessingFilter oAuth2Filter =
                new OAuth2ClientAuthenticationProcessingFilter("/google");

        OAuth2RestTemplate oAuth2RestTemplate =
                new OAuth2RestTemplate(authorizationCodeResourceDetails, oAuth2ClientContext);
        oAuth2Filter.setRestTemplate(oAuth2RestTemplate);

        oAuth2Filter.setTokenServices(new UserInfoTokenServices(resourceServerProperties.getUserInfoUri(),
                resourceServerProperties.getClientId()));

        return oAuth2Filter;
    }
}