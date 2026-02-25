package ge.tbc.testautomation.db;

import ge.tbc.testautomation.db.mappers.LocationsMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.h2.tools.Server;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            var server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers", "-ifNotExists").start();
            System.out.println("H2 database started at " + server.getURL());

            var jdbcUrl = "jdbc:h2:tcp://localhost:9092/./locationsDb;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;MODE=MSSQLServer;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE";

            try (var conn = DriverManager.getConnection(jdbcUrl);
                 var stmt = conn.createStatement()) {

                var dbInitScript = Files.readString(Path.of("src/main/resources/init.sql"));
                stmt.execute(dbInitScript);
                System.out.println("Init script executed");

                var dataSource = new PooledDataSource();
                dataSource.setDriver("org.h2.Driver");
                dataSource.setUrl(jdbcUrl);

                var transactionFactory = new JdbcTransactionFactory();
                var environment = new Environment("development", transactionFactory, dataSource);
                var configuration = new Configuration(environment);

                configuration.addMapper(LocationsMapper.class);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocationsMapper getLocationsMapper() {
        return sqlSessionFactory.openSession(true)
                .getMapper(LocationsMapper.class);
    }
}
