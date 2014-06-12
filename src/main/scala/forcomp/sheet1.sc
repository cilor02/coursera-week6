package forcomp

object sheet1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  List("one","two","three","four").foldLeft("")((a,b) => a.concat(b) )
                                                  //> res0: String = onetwothreefour
  List("one","two","three","four").foldLeft("")(_.concat(_) )
                                                  //> res1: String = onetwothreefour
           
  def remove2(forRemoval: List[Char], word : List[Char]):List[Char] =
{
  
 word match
 {
  case x if forRemoval.isEmpty => word
  case head::tail if word.exists((c) => c == head) => remove2 (forRemoval.tail, word.tail)
  case head::tail if !word.exists((c) => c == head) =>  List(head) ++ remove2(forRemoval.tail, word.tail)
  case Nil => Nil
 }

}                                                 //> remove2: (forRemoval: List[Char], word: List[Char])List[Char]

        
   
   val word = "advantage"                         //> word  : String = advantage
   val rem = ""                                   //> rem  : String = ""
   
   remove2(rem.toList, word.toList)               //> res2: List[Char] = List(a, d, v, a, n, t, a, g, e)
   
   
       def generateList(stem:String, word :String ):List[List[Char]] =
    {
      word.toList match
      {
        case head::tail => List (stem.toList ::: List[Char](head)) ::: generateList(stem,word.tail)
        case Nil => List()
      }
    }                                             //> generateList: (stem: String, word: String)List[List[Char]]
    
    generateList("","123")                        //> res3: List[List[Char]] = List(List(1), List(2), List(3))
    
    val evens = List(1,3,5,7,9)                   //> evens  : List[Int] = List(1, 3, 5, 7, 9)
val odds  = List(0,2,4,6,8)                       //> odds  : List[Int] = List(0, 2, 4, 6, 8)


odds.foldLeft(List[(Int,Int)]())((i1, i2) => i1 ::: evens.map((i)=>(i,i2)))
                                                  //> res4: List[(Int, Int)] = List((1,0), (3,0), (5,0), (7,0), (9,0), (1,2), (3,
                                                  //| 2), (5,2), (7,2), (9,2), (1,4), (3,4), (5,4), (7,4), (9,4), (1,6), (3,6), (
                                                  //| 5,6), (7,6), (9,6), (1,8), (3,8), (5,8), (7,8), (9,8))


def allSubsets (occs : (Char, Int)) : List[(Char,Int)]
=
{
  occs._2 match
  {
     case 0 => Nil
     case _ => occs :: allSubsets((occs._1,occs._2 - 1))
  }
}                                                 //> allSubsets: (occs: (Char, Int))List[(Char, Int)]

type Occurrences = List[(Char, Int)]

val list1 = allSubsets(('a',4))                   //> list1  : List[(Char, Int)] = List((a,4), (a,3), (a,2), (a,1))

val list2 = allSubsets(('b',3))                   //> list2  : List[(Char, Int)] = List((b,3), (b,2), (b,1))

val list5 = allSubsets(('c',1))                   //> list5  : List[(Char, Int)] = List((c,1))
//list1.foldLeft(List[List[(Char,Int)]]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a)))
val listx = (list1.foldLeft(List[Occurrences]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a))) ) :::list2.map(List(_))
                                                  //> listx  : List[List[(Char, Int)]] = List(List((b,3), (a,4)), List((b,2), (a,
                                                  //| 4)), List((b,1), (a,4)), List((b,3), (a,3)), List((b,2), (a,3)), List((b,1)
                                                  //| , (a,3)), List((b,3), (a,2)), List((b,2), (a,2)), List((b,1), (a,2)), List(
                                                  //| (b,3), (a,1)), List((b,2), (a,1)), List((b,1), (a,1)), List((b,3)), List((b
                                                  //| ,2)), List((b,1)))

val occs = List[Occurrences]()                    //> occs  : List[List[(Char, Int)]] = List()

def xyz (existingOccs: List[Occurrences], newOccs : Occurrences):List[Occurrences] =
{
newOccs.foldLeft(List[Occurrences]())((acc,foldItem)=> existingOccs.map((count) =>count ::: List(foldItem)))
}                                                 //> xyz: (existingOccs: List[forcomp.sheet1.Occurrences], newOccs: forcomp.shee
                                                  //| t1.Occurrences)List[forcomp.sheet1.Occurrences]

xyz(List[Occurrences](List(('a',1))),allSubsets(('b',3)))
                                                  //> res5: List[forcomp.sheet1.Occurrences] = List(List((a,1), (b,1)))

  def getAllSubsets(list1:List[(Char,Int)],occNew:(Char,Int)):List[List[(Char,Int)]] =
{
 val list2 = allSubsets(occNew)
(list1.foldLeft(List[List[(Char,Int)]]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a))) ) :::list2.map(List(_))
 }                                                //> getAllSubsets: (list1: List[(Char, Int)], occNew: (Char, Int))List[List[(Ch
                                                  //| ar, Int)]]
     val list4 = getAllSubsets(List[(Char,Int)](),('b',2))
                                                  //> list4  : List[List[(Char, Int)]] = List(List((b,2)), List((b,1)))
     val list3 = getAllSubsets(List[(Char,Int)](),('b',2))
                                                  //> list3  : List[List[(Char, Int)]] = List(List((b,2)), List((b,1)))
}