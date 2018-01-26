package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
public class MongoProperties {
    private String uriAgentProtocolGather;

    public String getUriAgentProtocolGather() {
        return uriAgentProtocolGather;
    }

    public void setUriAgentProtocolGather(String uriAgentProtocolGather) {
        this.uriAgentProtocolGather = uriAgentProtocolGather;
    }
}
