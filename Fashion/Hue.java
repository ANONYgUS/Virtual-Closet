// stores the hue of a color

public class Hue{

  private double xComp;
  private double yComp;

  public Hue(double a){
    xComp = Math.cos(a);
    yComp = Math.sin(a);
  }

  public Hue(double x, double y){
    xComp = x;
    yComp = y;
  }

  public Hue(int i){

    Hue(hToAngle(i));
  }

  public double hToAngle(int h){

  }
}
