package tr.com.akif.unlu.sensor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoSenderService {
  private final RestTemplate restTemplate;
  private final String url = "http://localhost:8080/processor";

  @Value("${sensor.x}")
  private int x;

  @Value("${sensor.y}")
  private int y;

  @Value("${sensor.id}")
  private String sensorId;

  public InfoSenderService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void sendInfo(double angle) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    InfoDto infoDto = new InfoDto();
    infoDto.setX(x);
    infoDto.setY(y);
    infoDto.setAngle(angle);
    infoDto.setSensorId(sensorId);
    HttpEntity<InfoDto> request = new HttpEntity<>(infoDto, headers);
    restTemplate.postForObject(url, request, Void.class);
  }
}
