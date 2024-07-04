package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPropertiesHolder {

    private static StarterAnimalProperties props;

    @Autowired
    public ApplicationPropertiesHolder(StarterAnimalProperties props) {
        ApplicationPropertiesHolder.props = props;
    }

    public static StarterAnimalProperties getApplicationProperties() {
        return props;
    }

    public static void setApplicationProperties(StarterAnimalProperties properties) {
        props = properties;
    }
}