package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author Kevin
 */
public class AdminFilter implements Filter {
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
           //cast to HTTP 
           HttpServletRequest httpRequest = (HttpServletRequest)request;        
           HttpServletResponse httpResponse = (HttpServletResponse) response;
           
           HttpSession session = httpRequest.getSession();                  
           
           int roleId = (int)session.getAttribute("roleId");
           //Check if user is an admin or not
                     
           //if admin: chain.doFilter(request, response);           
           if(roleId == 1) {           
            chain.doFilter(request, response);
           }else {
           //else send to: httpResponse.sendRedirect("/notes");
            httpResponse.sendRedirect("/notes");
           }
       }
        
    


    /**
     * Destroy method for this filter
    */
    public void destroy() {        
    }
    /**
     * Init method for this filter
    */
    public void init(FilterConfig filterConfig) {        
        
    }
}
