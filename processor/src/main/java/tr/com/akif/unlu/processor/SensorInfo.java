package tr.com.akif.unlu.processor;

public class SensorInfo {
  private double m;
  private double b;

  public SensorInfo() {}

  public SensorInfo(double m, double b) {
    this.m = m;
    this.b = b;
  }

  public double getM() {
    return m;
  }

  public void setM(double m) {
    this.m = m;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }
}
