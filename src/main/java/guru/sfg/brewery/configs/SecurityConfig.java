package guru.sfg.brewery.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity) ((HttpSecurity) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)
        http
            .authorizeRequests(authorize -> {
                authorize
                        .antMatchers("/").permitAll()
                        .antMatchers("/webjars/**").permitAll()
                        .antMatchers("/resources/**").permitAll()
                        .antMatchers("/beers/find").permitAll()
                        .antMatchers("/beers*").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/v1/beer/**").permitAll()
                        .antMatchers("/login").permitAll()
                        // Matches path variables
                        .mvcMatchers(HttpMethod.GET, "/api/v1/beerUpc/{upc}").permitAll()
                ;
            })
            .authorizeRequests()
            .anyRequest())
            .authenticated().and()).formLogin().and()).httpBasic();
    }
}
