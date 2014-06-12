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
}