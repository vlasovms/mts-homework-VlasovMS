package Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggerInterceptor implements HandlerInterceptor {
    public static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
}
