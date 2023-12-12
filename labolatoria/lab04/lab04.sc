import java.lang

type Type2D = (Float, Float)
type TypeND = List[Float]
type Person = (String,String,Int,Boolean,Int)
type Partnership = (Person,Person)
type DimensionsMax3D = (Double,Double,Double)
case class CPerson(Imie:String,Nazwisko:String,Wiek:Int,Plec:Boolean,NumberButa:Int)
case class CPartnership(first:CPerson,second:CPerson)

enum SolidFigure:
  case Cuboid(length: Double, width: Double, height: Double)
  case Cone(radius: Double, height: Double)
  case Sphere(radius: Double)
  case Cylinder(radius: Double, height: Double)

enum WeekDay:
  case Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
  
enum Maybe[+A]:
  case Just(value:A)
  case Nothing


def distance(first: Type2D, second: Type2D): Float={

  val xdist_sqr = Math.pow(first._1-second._1,2)
  val ydist_sqr = Math.pow(first._2-second._2,2)
  Math.sqrt(xdist_sqr+ydist_sqr).toFloat
}


def distanceND(first:TypeND,second:TypeND): Float={
  Math.sqrt(first.zip(second).map((c1:Float,c2:Float)=>Math.pow((c1-c2),2)).sum).toFloat
}


def chooseBiggerFoot(partnership: Partnership):Person={
  if partnership._1._5 > partnership._2._5 then partnership._1 else partnership._2
}

def chooseBiggerFoot(partnership: CPartnership):CPerson={
  if partnership.first.NumberButa > partnership.second.NumberButa then partnership._1 else partnership._2
}


def dayOfWeek(day: WeekDay): String = day match {
  case WeekDay.Monday => "Monday"
  case WeekDay.Tuesday => "Tuesday"
  case WeekDay.Wednesday => "Wednesday"
  case WeekDay.Thursday => "Thursday"
  case WeekDay.Friday => "Friday"
  case WeekDay.Saturday => "Saturday"
  case WeekDay.Sunday => "Sunday"
}
def nextDayOfWeek(day:WeekDay):WeekDay=day match{
  case WeekDay.Monday => WeekDay.Tuesday
  case WeekDay.Tuesday => WeekDay.Wednesday
  case WeekDay.Wednesday => WeekDay.Thursday
  case WeekDay.Thursday => WeekDay.Friday
  case WeekDay.Friday => WeekDay.Saturday
  case WeekDay.Saturday =>  WeekDay.Sunday
  case WeekDay.Sunday => WeekDay.Monday
}

def SafeHead[A](lista:List[A]):Maybe[A]={
  lista match  {
    case Nil => Maybe.Nothing
    case head::_ => Maybe.Just(head)
  }
}

def volume(figure:SolidFigure):Double={
  figure match {
    case SolidFigure.Cuboid(len,width,height)=>len*width*height
    case SolidFigure.Sphere(radius) =>(4.0 / 3.0) * math.Pi * radius * radius * radius
    case SolidFigure.Cone(radius,height) =>(1.0/3.0)*math.Pi*radius*radius*height
    case SolidFigure.Cylinder(radius, height) => math.Pi * radius * radius * height
  }

}