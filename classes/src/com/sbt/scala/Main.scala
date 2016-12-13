package com.sbt.scala

/**
  * Created by vasiliy on 13.12.16.
  */
object Main {


  def main(args:Array[String]):Unit = {
    println("Hello Classes")

   val person = new Person("Martin Odersky")
   println(s"Person name is ${person.name}")

   val auto = new Auto("Ferrari")
   auto.firm = "Audi"

   println(s"Auto firm is ${auto.firm}")

   val book = new Book("Beginning Scala")
  // println(book.name) compilation error

   val home = new Home("Zhelezka")
   home.printHome()
   home.printHome(new Home("Vychino"))

   val guitar = new Guitar
   println(guitar.name)
    val guitarPrs = new Guitar("PRS")
   println(guitarPrs.name)
   val guitarFender = new Guitar
   println(guitarFender.name)

   val combic = new Combic(10)
   println(combic.pp())

  }

}

class Person(val name:String) // поле нельзя изменить ни внешне ни внутри
class Auto(var firm:String)    // поле можно изменить и снаружи и изнутри
class Book(private var name:String)  // поле можно изменить внутри класса но нет внешнего доступа
class Employee(private val name:String)  // поле нельзя изменить внутри класса и нет внешнего доступ
class Home(val address:String){ // при отсутствии модификатора address не будет относится к Home
  def printHome():Unit = println(address)
  def printHome(home:Home):Unit = println(home.address)
}

// constructor with default parameter
class Guitar(val name:String = "Gibson") {
  def this() {
    this("Figa") // переопределение конструктора. он обязательно должен вызывать вышестоящий
  }
}

class Combic(val firm:String,val color:String){
  def this(price:Int){
    this("Fender","Black")
    println(price)
  }

  def pp():String = this.firm
}


