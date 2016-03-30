package jp.co.worksap.stm.solaris.interceptors;

import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//for simplified implementation of pre-only/post-only interceptor
public class AccessControllInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private EmployeeService employeeService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// If current user has been authenticated
		if (request.getUserPrincipal() != null) {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			// Map & Set current authenticated user role from the authentication
			// acquired if no user role
			if (request.getSession().getAttribute("roles") == null) {
				request.getSession().setAttribute(
						"roles",
						auth.getAuthorities().stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()));
			}
			// Redirection after login; set language according to user role
			if (request.getRequestURI().toString().endsWith("login")) {
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}

		}
		return true;
	}
}
