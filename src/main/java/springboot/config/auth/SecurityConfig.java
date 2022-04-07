package springboot.config.auth;



import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springboot.domain.user.Role;

@RequiredArgsConstructor
@EnableWebSecurity//Spring Security 설정들을 활성화 시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //csrf().disable().headers().frameOptions().disable()
        //h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests() //authorizeRequests : URL 별 권한 관리를 설정하는 옵션의 시작점이다.
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() //antMatchers : 권한 관리 대상을 지정하는 옵션이다
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() //anyRequest : 설정된 값들 이외 나머지 URL들을 나타낸다.
                .and()
                .logout()
                .logoutSuccessUrl("/")  //logout().logoutSuccessUrl("/") : 로그아웃 기능에 대한 여러 설정의 진입점이다.
                .and()
                .oauth2Login() // oauth2login : OAuth2 로그인 기능에 대한 여러 설정의 진입점이다
                .userInfoEndpoint() // userInfoEndpoint : OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당한다
                .userService(customOAuth2UserService); //userService 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
    }
}