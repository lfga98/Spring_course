package uaz.ejemplo.edu.demouaz.ejemplo.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar").permitAll()
        .antMatchers("/ver/**").hasAnyRole("USER")
        .antMatchers("/uploads/**").hasAnyRole("USER")
        .antMatchers("/form/**").hasAnyRole("ADMIN")
        .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
        .antMatchers("/factura/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll()
        .and().exceptionHandling().accessDeniedPage("/error_403");
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);
        build.inMemoryAuthentication().withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
        .withUser(users.username("andres").password("123").roles("USER"));

    }


}
