package com.plmarket.db.embedded;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

/**
 * Enables an embedded database for JUnit tests.
 * The database automatically starts in Docker at the beginning of testing,
 * initializes and stops at the end of the testing.
 *
 * @author azabezhinsky
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "datasource.configurations[default].url="
                + "jdbc:tc:postgresql:12.3://localhost/db",
        "datasource.configurations[default].username=test_user",
        "datasource.configurations[default].password=",
        "datasource.configurations[default].driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
})
public @interface EmbeddedDb {
}
