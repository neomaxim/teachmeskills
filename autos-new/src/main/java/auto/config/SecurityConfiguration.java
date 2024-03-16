package auto.config;


import auto.config.security.JwtFilter;
import auto.service.AuthenticationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import static auto.controller.AuthController.AUTH_REQUEST_MAPPING;
import static auto.service.Authorities.ADMIN;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final AuthenticationHandler authenticationHandler;

    private final JwtFilter jwtFilter;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/*/style.css", "/webjars/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()

                .authorizeRequests()
                .antMatchers("/", AUTH_REQUEST_MAPPING).permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasAuthority(ADMIN)
                // .antMatchers("/api/auto/*").hasAnyRole("ROLE_" + ADMIN)
                .antMatchers("/api/*").authenticated()


                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // .formLogin()
                //  .loginPage("/users/login")
                //  .httpBasic()
                .and()
                .addFilterAfter(jwtFilter, AnonymousAuthenticationFilter.class)
                //          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
//                .logout(logout -> logout
//                        .logoutUrl("/my/logout")
//                        .logoutSuccessUrl("/my/index")
////                        .logoutSuccessHandler(authenticationHandler)
//                        .invalidateHttpSession(true)
//                        .addLogoutHandler(authenticationHandler)
//                        .deleteCookies("JSESSIONID")
//                )
        //       .addLogoutHandler(authenticationHandler)
        ;




               /* .authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/api/**").authenticated()
                .antMatchers("/api/auto/*").hasAnyRole("ROLE_" + ADMIN)
                .antMatchers("/api/users/*").hasAnyRole("ROLE_" + ADMIN, "ROLE_" + USER)
                .and()
                .formLogin()
                .and()
                .logout()
                .addLogoutHandler(authenticationHandler);*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


}