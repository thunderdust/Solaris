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

	// Customized matcher to allow some request skip from CSRF protection
	RequestMatcher csrfRequestMatcher = new RequestMatcher() {

		private String allowedMethod = "GET";

		private AntPathRequestMatcher[] requestMatchers = {
				new AntPathRequestMatcher("/login"),
				new AntPathRequestMatcher("/logout"),
				new AntPathRequestMatcher("/employees/**"),
				new AntPathRequestMatcher("/products/**"),
				new AntPathRequestMatcher("/customers/**"),
				new AntPathRequestMatcher("/orders/**"),
				new AntPathRequestMatcher("/sendEmail"),
				new AntPathRequestMatcher("/trainings")
				
		};

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
		http
		// anyone can access /login url
		// free access to resources files
		.authorizeRequests()
				.antMatchers("/resources/**", "/login/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				// specify login form url and url when login failed
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				// specify login parameters
				.passwordParameter("password")
				.permitAll()
				.and()
				// specify logout settings
				.logout()
				.logoutUrl("/logout")
				.logoutRequestMatcher(
						new AntPathRequestMatcher("/logout", "POST"))
				.logoutSuccessUrl("/login").permitAll()
				// Apply customized csrf request mathcer
				.and().csrf().requireCsrfProtectionMatcher(csrfRequestMatcher)
				.and();
	}

	// authentication with hashed password
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				new PasswordHash());
	}

	/*
	 * // for test purpose
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("user").password("user")
	 * .roles("TESTER"); }
	 */

}
