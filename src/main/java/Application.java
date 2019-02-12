import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    @Autowired
    Vertx vertx;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
