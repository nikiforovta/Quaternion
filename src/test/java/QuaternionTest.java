import org.junit.*;
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
    assertEquals(new Quaternion(92, 6.0, 0, -1),
            new Quaternion(90, 4.2, 0, -2).plus(new Quaternion(2, 1.8, 0, 0.65)));
  }

  @Test
  public void minus() {
    assertEquals(new Quaternion(2, 2, 0, 1),
            new Quaternion(92, 6, 0, -1.35).minus(new Quaternion(90, 4.2, 0, -2)));
  }

  @Test
  public void times() {
    assertEquals(new Quaternion(174, 170, -6, 55),
            new Quaternion(90, 4.2, 0, -2).times(new Quaternion(2, 1.8, 0, 0.65)));
  }

  @Test
  public void divide() {
    assertEquals(new Quaternion(0.0, 0.0, 0.0, 0.0),
          new Quaternion(1, 1, 1, 1).divide(new Quaternion(33, 33, 33, 33)));
  }

  @Test
  public void abs() {
    assertEquals(2.0,
            new Quaternion(1, 1, 1, 1).abs(), 10-5);
    assertEquals(66.0,
            new Quaternion(33, 33, 33, 33).abs(), 10-5);
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
  public void equals() {
    assertEquals(new Quaternion(1, 2, 3, 4), new Quaternion(1, 2, 3, 4));
    assertEquals(new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596),
            new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596));
    assertNotEquals(new Quaternion(1, 2, 3, 4),
            new Quaternion(-1, 0.0566486529, -6.27575, 85.6481596));
  }
}