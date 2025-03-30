package io.github.ertansidar.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@Profile("jpa")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class JpaAuditConfig {

}
