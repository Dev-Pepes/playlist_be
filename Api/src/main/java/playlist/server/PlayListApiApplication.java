package playlist.server;


import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@EntityScan("playlist.server.domain")
@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class PlayListApiApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(PlayListApiApplication.class, args);
        log.info("Server Processed : " + LocalDateTime.now());
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("applicationReady status" + Arrays.toString(environment.getActiveProfiles()));
    }
}
