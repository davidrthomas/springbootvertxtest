import io.vertx.core.Vertx;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.Future;

@RestController
public class HelloController {

    private final Vertx vertx;

    public HelloController(Vertx vertx) {
        this.vertx = vertx;
    }

    @GetMapping("/api/name/{name}")
    public String index(@PathVariable("name") String name) throws Exception {
        //CompletableFuture<Vertx> future = new CompletableFuture<>();
        Future<String> future = Future.future();
        vertx.eventBus().<String>send("hello", name, ar -> {
            if (ar.succeeded()) {
                future.complete(ar.result().body());
            } else {
                //request.response().setStatusCode(500).end(ar.cause().getMessage());
                future.fail(ar.cause());
            }
        });
        future.setHandler(ar -> ar.succeeded());
        return "";
    }
}
