package tr.com.akif.unlu.target;

import jakarta.annotation.PostConstruct;
import java.util.Random;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  private final Logger log = org.slf4j.LoggerFactory.getLogger(LocationService.class);

  private int x;
  private int y;
  private final Random rand = new Random();

  @PostConstruct
  public void init() {
    x = rand.nextInt(1001);
    y = rand.nextInt(1001);
    log.info("x={}, y={}", x, y);
  }

  public TargetDto getLocationInformation(TargetRequestDto request) {
    int deltaY = request.getY() - y;
    int deltaX = request.getX() - x;
    double angleInRadians = Math.atan2(deltaY, deltaX);
    double angleInDegrees = Math.toDegrees(angleInRadians);
    if (angleInDegrees < 0) {
      angleInDegrees += 360;
    }
    return new TargetDto(angleInDegrees);
  }
}
