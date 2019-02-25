package quaternion;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuaternionTest {

  @Test
  public void timesScal() {
    assertEquals(new Quaternion(16, 3.7, 9, 24),
            new Quaternion(8, 1.85, 4.5, 12).timesScal(2));
  }

  @Test
  public void pairing() {
    assertEquals(new Quaternion(16, -3.7, -9, -24),
            new Quaternion(16, 3.7, 9, 24).pairing());
  }

  @Test
  public void plus() {
    assertEquals(new Quaternion(92, 6.0, 0, -1.35),
            new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65)));
  }

  @Test
  public void minus() {
    assertEquals(new Quaternion(2, 1.8, 0, 0.65,
            new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2))));
  }

  @Test
  public void times() {
    assertEquals(new Quaternion(173.74, 170.4, -6.33, 54.5),
            new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65)));
  }

  @Test
  public void divide() {
    assertEquals(new double(0.03030303030303030),
            new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33)));
  }

  @Test
  public void abs() {
    assertEquals(new double(2),
            new Quaternion(1, 1, 1, 1).abs());
    assertEquals(new double(66),
            new Quaternion(33, 33, 33, 33).abs());
  }

  @Test
  public void getScal() {
    assertEquals(0.5, new Quaternion(0.5, 6, 123435, 0.00005).getScal());
  }

  @Test
  public void getVector() {
    assertEquals("6i + 123435j + 0k", new Quaternion(0.5, 6, 123435, 0).getVector());
  }

  @Test
  public void norm() {
    assertEquals(new Quaternion(16.5, 16.5, 16.5, 16.5), new Quaternion(33, 33, 33, 33).norm());
    assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5), new Quaternion(1, 1, 1, 1).norm());
  }
}