package tr.com.akif.unlu.sensor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SensorService {
  private final RestTemplate restTemplate;
  private final InfoSenderService infoSenderService;
  private final String url = "http://localhost:8082/target";

  @Value("${sensor.id}")
  private String sensorId;

  @Value("${sensor.x}")
  private int x;

  @Value("${sensor.y}")
  private int y;

  public SensorService(RestTemplate restTemplate, InfoSenderService infoSenderService) {
    this.restTemplate = restTemplate;
    this.infoSenderService = infoSenderService;
  }

  @Scheduled(cron = "0/5 * * * * ?")
  public void determineTarget() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    TargetRequestDto requestObject = new TargetRequestDto(x, y);
    HttpEntity<TargetRequestDto> request = new HttpEntity<>(requestObject, headers);
    TargetDto target = restTemplate.postForObject(url, request, TargetDto.class);
    infoSenderService.sendInfo(target.getAngle());
    System.out.println("Sensor: " + sensorId + " " + "Target: " + target.getAngle());
  }
}
