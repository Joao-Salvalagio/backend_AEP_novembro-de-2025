package vamos_reciclar_maringa.AEP.others;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean //serve para indicar que um metodo dentro de uma classe de configuração @Configuration é responsável por criar e retornar uma instancia de um bean.
    public PasswordEncoder passwordEncoder() {
        //usa o algoritmo BCrypt, o padrão de mercado para senhas (criptografia) obs: foi um plus, a gente se empolgou e gostou de criar o projeto
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //por padrao, o Spring Security bloqueia TUDO. este código "libera" todas as nossas APIs.
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable());

        return http.build();
    }
}