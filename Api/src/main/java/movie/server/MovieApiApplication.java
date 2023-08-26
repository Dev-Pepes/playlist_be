package movie.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.Arrays;

@EntityScan("movie.server.domain")
@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class MovieApiApplication implements ApplicationListener<ApplicationReadyEvent> {
  
  private final Environment environment;
  
  public static void main(String[] args) {
    SpringApplication.run(MovieApiApplication.class, args);
    System.out.println("Server Processed : " + LocalDateTime.now());
  }
  
  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    log.info("applicationReady status" + Arrays.toString(environment.getActiveProfiles()));
  }
}
