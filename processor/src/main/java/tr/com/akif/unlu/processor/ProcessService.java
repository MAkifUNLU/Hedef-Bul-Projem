package tr.com.akif.unlu.processor;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProcessService.class);

  private SensorInfo sensor1;
  private SensorInfo sensor2;

  public void process(InfoDto infoDto) {
    if (infoDto.getSensorId().equals("sensor-1")) {
      sensor1 = calculateSensor(infoDto);
    }
    if (infoDto.getSensorId().equals("sensor-2")) {
      sensor2 = calculateSensor(infoDto);
    }
    if (sensor1 != null && sensor2 != null) {
      if (sensor1.getM() == sensor2.getM() || sensor1.getB() == sensor2.getB()) {
        return;
      }
      double x = (sensor2.getB() - sensor1.getB()) / (sensor1.getM() - sensor2.getM());
      double y = sensor1.getM() * x + sensor1.getB();
      log.info("Hedef X/Y: {} - {}", x, y);
    }
  }

  private SensorInfo calculateSensor(InfoDto infoDto) {
    SensorInfo sensorInfo = new SensorInfo();
    double angleRadians = Math.toRadians(infoDto.getAngle());
    double m = Math.tan(angleRadians);
    double b = infoDto.getY() - m * infoDto.getX();
    sensorInfo.setM(m);
    sensorInfo.setB(b);
    return sensorInfo;
  }
}
