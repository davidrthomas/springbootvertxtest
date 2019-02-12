
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import java.util.UUID;

public class HelloVerticle extends AbstractVerticle {
    private static final String ID = UUID.randomUUID().toString();

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().<String>consumer("hello", message -> {
            message.reply("Hello " + message.body() + " from " + ID);
        }).completionHandler(startFuture);
    }
}