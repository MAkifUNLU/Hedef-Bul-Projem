package tr.com.akif.unlu.processor;

public class InfoDto {
  private double angle;
  private int x;
  private int y;
  private String sensorId;

  public InfoDto() {}

  public InfoDto(double angle, int x, int y, String sensorId) {
    this.angle = angle;
    this.x = x;
    this.y = y;
    this.sensorId = sensorId;
  }

  public double getAngle() {
    return angle;
  }

  public void setAngle(double angle) {
    this.angle = angle;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String getSensorId() {
    return sensorId;
  }

  public void setSensorId(String sensorId) {
    this.sensorId = sensorId;
  }
}
