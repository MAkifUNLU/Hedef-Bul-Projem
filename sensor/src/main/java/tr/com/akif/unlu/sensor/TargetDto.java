package tr.com.akif.unlu.sensor;

public class TargetDto {
  private double angle;

  public TargetDto() {}

  public TargetDto(double angle) {
    this.angle = angle;
  }

  public double getAngle() {
    return angle;
  }

  public void setAngle(double angle) {
    this.angle = angle;
  }
}
