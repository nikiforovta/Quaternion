package quaternion;
import java.util.*;
import static java.lang.Math.*;

public final class Quaternion {
  private final double rat;
  private final double i;
  private final double j;
  private final double k;

  public Quaternion(double rat, double i, double j, double k) {
    this.rat = rat;
    this.i = i;
    this.j = j;
    this.k = k;
  }

  //построение кватерниона заданием оси и угла поворота
  public Quaternion axisAngle(Vector<Double> axis, double angle) {
    double halfAngle = angle / 2;
    double rat = axis.get(0) * cos(halfAngle);
    double i = axis.get(0) * sin(halfAngle);
    double j = axis.get(1) * cos(halfAngle) - axis.get(2) * sin(halfAngle);
    double k = axis.get(1) * sin(halfAngle) - axis.get(2) * cos(halfAngle);
    return new Quaternion(rat, i, j, k);
  }

  //умножение на скаляр
  public Quaternion timesScal(double a) {
    return new Quaternion(rat * a, i * a, j * a, k * a);
  }

  //сопряжение
  public Quaternion pairing() {
    return new Quaternion(rat, -i, -j, -k);
  }

  //сложение
  public Quaternion plus(Quaternion other) {
    return new Quaternion(rat + other.rat, i + other.i, j + other.j, k + other.k);
  }

  //вычитание
  public Quaternion minus(Quaternion other) {
    return new Quaternion(rat - other.rat, i - other.i, j - other.j, k - other.k);
  }

  //умножение
  public Quaternion times(Quaternion other) {
    double rat = this.rat * other.rat - this.i * other.i - this.j * other.j - this.k * other.k;
    double i = this.rat * other.i + this.i * other.rat + this.j * other.k - this.k * other.j;
    double j = this.rat * other.j + this.j * other.rat + this.k * other.i - this.i * other.k;
    double k = this.rat * other.k + this.i * other.j + this.k * other.rat - this.j * other.k;
    return new Quaternion(rat, i, j, k);
  }

  //деление
  public Quaternion divide(Quaternion other) {
    return this.times(other.pairing()).timesScal(pow(other.abs(), -2));
  }

  //модуль
  public double abs() {
    return sqrt(rat * rat + i * i + j * j + k * k);
  }

  //получение скалярной части
  public double getScal() {
    return rat;
  }

  //получение векторной части
  public String getVector() {
    return (i + "i + " + j + "j + " + k + "k");
  }

  //нормирование
  public Quaternion norm() {
    return this.timesScal(1 / this.abs());
  }

  //определение угла поворота
  public double getAngle() {
    return 2 * atan2(i, rat);
  }

  //определение оси
  public Vector<Double> getAxis() {
    double halfAngle = this.getAngle() / 2;
    Vector<Double> res = new Vector<>();
    res.add(0, rat / cos(halfAngle));
    res.add(1, j * cos(halfAngle) + k * sin(halfAngle));
    res.add(2, -j * sin(halfAngle) + k * cos(halfAngle));
    return res;
  }
}