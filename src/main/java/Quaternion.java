import static java.lang.Math.*;

public final class Quaternion {
  private final double rat;
  private final double i;
  private final double j;
  private final double k;

  Quaternion(double a, double b, double c, double d) {
    this.rat = a;
    this.i = b;
    this.j = c;
    this.k = d;
  }

  //получение скалярной части
  public double getScal() {
    return rat;
  }

  public double getI() {
    return i;
  }

  public double getJ() {
    return j;
  }

  public double getK() {
    return k;
  }
  //построение кватерниона заданием оси и угла поворота

  public static Quaternion axisAngle(double[] axis, double angle) {
    double halfAngle = angle / 2;
    double rat = cos(halfAngle);
    double i = axis[0] * sin(halfAngle);
    double j = axis[1] * sin(halfAngle);
    double k = axis[2] * sin(halfAngle);
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
    return (this.times(other.pairing()).timesScal(pow(other.abs(), -2)));
  }
  //модуль

  public double abs() {
    return round(sqrt(rat * rat + i * i + j * j + k * k));
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
    return 2 * acos(rat);
  }

  //определение оси
  public double[] getAxis() {
    double halfAngle = this.getAngle() / 2;
    double[] res = new double[3];
    res[0] = i / sin(halfAngle);
    res[1] = j / sin(halfAngle);
    res[2] = k / sin(halfAngle);
    return res;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj instanceof Quaternion) {
      Quaternion other = (Quaternion) obj;
      return rat == other.rat && i == other.i && j == other.j && k == other.k;
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder a = new StringBuilder();
    if (rat < 0) a.append("-");
    a.append(rat);
    if (i > 0.0) a.append("+");
    a.append(i).append("i");
    if (j > 0.0) a.append("+");
    a.append(j).append("j");
    if (k > 0.0) a.append("+");
    a.append(k).append("k");
    return a.toString();
  }
}