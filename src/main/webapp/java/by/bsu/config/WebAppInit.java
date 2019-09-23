package by.bsu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String MAPPING = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{MAPPING};
    }
}
