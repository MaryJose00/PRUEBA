package com.distribuida.config;

/*import com.zaxxer.hikari.HikariDataSource;
import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import io.helidon.dbclient.jdbc.ConnectionPool;
import io.helidon.dbclient.jdbc.JdbcDbClientProviderBuilder;
import io.helidon.dbclient.spi.DbClientProvider;
import io.helidon.dbclient.spi.DbClientProviderBuilder;*/
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DbConfig {

    @Produces
    @RequestScoped
    public EntityManager getSession () {
        Map<String, String> map = System.getenv();

        Map<String, Object> map1 = new HashMap<String, Object>();

        for (String map2 : map.keySet()) {
            if (map2.contains("db_user")) {
                map1.put("jakarta.persistence.jdbc.user", map.get(map2));
            }
            if (map2.contains("db_password")) {
                map1.put("jakarta.persistence.jdbc.password", map.get(map2));
            }
            if (map2.contains("db_url")) {
                map1.put("jakarta.persistence.jdbc.url", map.get(map2));
            }
        }
        EntityManagerFactory base = Persistence.createEntityManagerFactory("base", map1);
        return base.createEntityManager();
    }

}



