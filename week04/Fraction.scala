case class Fraction(numer : Int, denom : Int) {

  def *(other : Fraction) = Fraction(numer * other.numer, denom * other.denom)

  def +(other : Fraction) = {

    other match {
      case Fraction(othernumer, otherdenom) => { 
        val my_lcm = Fraction.lcm(denom, otherdenom)
        Fraction(numer * (my_lcm / denom) + othernumer * (my_lcm / otherdenom), my_lcm) 
      }
    }
  }

  def simplify = Fraction(numer / Fraction.gcd(numer,denom), denom / Fraction.gcd(numer, denom))
 
  override def toString() = "Fraction(" + numer + "/" + denom+")"

}

object Fraction {
  def gcd(a : Int, b : Int) : Int =
     if (b == 0)  a  else gcd(b, a % b)

  def lcm(a : Int, b : Int) : Int =
     a * b / (if (a > b) gcd(a, b) else gcd(b,a))

  def main(args : Array[String]) = {
    val x = Fraction(1,2);
    val y = Fraction(3,4);
    val z = x + y // x.+(y) 
    println(z.simplify);
  }

}
