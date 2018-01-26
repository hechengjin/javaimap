package config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackages = "database.mongodb.repo.FolderInfoImap", mongoTemplateRef = "folderInfoImapMongoTemplate")
public class FolderImapMongoConfiguration extends MongoConfiguration {
    public FolderImapMongoConfiguration(MongoProperties mongoProperties) {
        super(mongoProperties);
    }

    @Bean
    public MongoTemplate proxyMongoTemplate() {
        return new MongoTemplate(proxyMongoFactory());
    }

    @Bean
    public MongoDbFactory proxyMongoFactory() {
        MongoClientURI mongoClientURI = new MongoClientURI(getMongoProperties().getUriAgentProtocolGather());
        try {
            return new SimpleMongoDbFactory(mongoClientURI);
        } catch (UnknownHostException e) {
            throw new RuntimeException("Init proxy mongodb factory error.", e);
        }
    }
}
