package config;

public class MongoConfiguration {
    private MongoProperties mongoProperties;

    public MongoConfiguration(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    MongoProperties getMongoProperties() {
        return mongoProperties;
    }
}
