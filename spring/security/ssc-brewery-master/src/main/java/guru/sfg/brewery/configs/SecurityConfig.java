package guru.sfg.brewery.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RestHeaderAuthenticationFilter filter = new RestHeaderAuthenticationFilter(new AntPathRequestMatcher("/api/**"));
        filter.setAuthenticationManager(this.authenticationManager());

        http
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/", "/webjars/**", "/resources/**")
                                .permitAll()
                                .antMatchers("/beers/find", "/beers*")
                                .permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/beer/**")
                                .permitAll()
                                .mvcMatchers(HttpMethod.GET, "/api/v1/beerUpc/{upc}")
                                .permitAll()

                )
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("{noop}user")
                .roles("USER");
    }

    //    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }
    //Api-Key
    //Api-secret
}
