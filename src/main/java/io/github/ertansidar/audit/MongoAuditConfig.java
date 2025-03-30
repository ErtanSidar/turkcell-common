package io.github.ertansidar.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@Profile("mongo")
@EnableMongoAuditing(auditorAwareRef = "auditAwareImpl")
public class MongoAuditConfig {
}