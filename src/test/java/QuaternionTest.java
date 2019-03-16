import org.junit.Test;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuaternionTest {

  @Test
  public void axisAngle() {
    double[] check = {1.0, 0.0, 0.0};
    assertEquals(0.7071, Quaternion.axisAngle(check, PI / 2).getScal(), 10E-5);
    assertEquals(0.7071, Quaternion.axisAngle(check, PI / 2).getI(), 10E-5);
    assertEquals(0.0, Quaternion.axisAngle(check, PI / 2).getJ(), 10E-5);
    assertEquals(0.0, Quaternion.axisAngle(check, PI / 2).getK(), 10E-5);
  }

  @Test
  public void timesScal() {
    assertEquals(16.0, new Quaternion(8, 1.85, 4.5, 12).timesScal(2).getScal(), 10E-5);
    assertEquals(3.7, new Quaternion(8, 1.85, 4.5, 12).timesScal(2).getI(), 10E-5);
    assertEquals(9.0, new Quaternion(8, 1.85, 4.5, 12).timesScal(2).getJ(), 10E-5);
    assertEquals(24.0, new Quaternion(8, 1.85, 4.5, 12).timesScal(2).getK(), 10E-5);
  }

  @Test
  public void pairing() {
    assertEquals(new Quaternion(16, -3.7, -9, -24),
            new Quaternion(16, 3.7, 9, 24).pairing());
  }

  @Test
  public void plus() {
    assertEquals(92.0, (new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65))).getScal(), 10E-5);
    assertEquals(6.0, (new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65))).getI(), 10E-5);
    assertEquals(0.0, (new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65))).getJ(), 10E-5);
    assertEquals(-1.35, (new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65))).getK(), 10E-5);

  }

  @Test
  public void minus() {
    assertEquals(2.0, (new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2))).getScal(), 10E-5);
    assertEquals(1.8, (new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2))).getI(), 10E-5);
    assertEquals(0.0, (new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2))).getJ(), 10E-5);
    assertEquals(0.65, (new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2))).getK(), 10E-5);
  }

  @Test
  public void times() {
    assertEquals(173.74, (new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65))).getScal(), 10E-5);
    assertEquals(170.4, (new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65))).getI(), 10E-5);
    assertEquals(-6.33, (new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65))).getJ(), 10E-5);
    assertEquals(54.5, (new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65))).getK(), 10E-5);
  }

  @Test
  public void divide() {
    assertEquals(0.030303, (new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33))).getScal(), 10E-5);
    assertEquals(0.0, (new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33))).getI(), 10E-5);
    assertEquals(0.0, (new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33))).getJ(), 10E-5);
    assertEquals(0.0, (new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33))).getK(), 10E-5);
  }

  @Test
  public void abs() {
    assertEquals(2.0, new Quaternion(1, 1, 1, 1).abs(), 10E-5);
    assertEquals(66.0, new Quaternion(33, 33, 33, 33).abs(), 10E-5);
  }

  @Test
  public void getScal() {
    assertEquals(0.5, new Quaternion(0.5, 6, 123435, 0.00005).getScal(), 0);
  }

  @Test
  public void getVector() {
    assertEquals("6.0i + 123435.0j + 0.0k",
            new Quaternion(0.5, 6, 123435, 0).getVector());
  }

  @Test
  public void norm() {
    assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5), new Quaternion(33, 33, 33, 33).norm());
    assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5), new Quaternion(1, 1, 1, 1).norm());
  }

  @Test
  public void getAngle() {
    assertEquals(PI / 2, new Quaternion(0.7071, 0, 0, 0).getAngle(), 10E-5);
  }

  @Test
  public void getAxis() {
    double[] check = {1.0, 0.0, 0.0};
    double[] result = new Quaternion(0.7071, 0.7071, 0.0, 0.0).getAxis();
    assertEquals(check[0], result[0], 10E-5);
    assertEquals(check[1], result[1], 10E-5);
    assertEquals(check[2], result[2], 10E-5);
  }

  @Test
  public void equals() {
    assertEquals(new Quaternion(1, 2, 3, 4), new Quaternion(1, 2, 3, 4));
    assertEquals(new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596),
            new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596));
    assertNotEquals(new Quaternion(1, 2, 3, 4),
            new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596));
  }
}