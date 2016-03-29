package jp.co.worksap.stm.solaris;

import javax.servlet.http.HttpServletRequest;

import jp.co.worksap.stm.solaris.utils.PasswordHash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	RequestMatcher csrfRequestMatcher = new RequestMatcher() {

		private String allowedMethod = "GET";

		private AntPathRequestMatcher[] requestMatchers = {
				new AntPathRequestMatcher("/login"),
				new AntPathRequestMatcher("/logout"),
				new AntPathRequestMatcher("/employeemanagement/**") };

		@Override
		public boolean matches(HttpServletRequest request) {
			// TODO Auto-generated method stub
			for (AntPathRequestMatcher rm : requestMatchers) {
				if (rm.matches(request)) {
					return false;
				}
			}
			if (request.getMethod().equals(allowedMethod)) {
				return false;
			}
			return true;
		}
	};

	// Configure access for different URLs
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.requireCsrfProtectionMatcher(csrfRequestMatcher)
				.and()
				// anyone can access /login url
				.authorizeRequests().antMatchers("/login/**").permitAll()
				.anyRequest().authenticated()
				.and()
				// specify login form url and url when login failed
				.formLogin().loginPage("/login")
				.failureUrl("/login")
				// specify login parameters
				.passwordParameter("password").usernameParameter("username")
				.permitAll().and()
				// specify logout settings
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
				.permitAll();
	}

	// Configure the password encoder for authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				new PasswordHash());
	}
}
