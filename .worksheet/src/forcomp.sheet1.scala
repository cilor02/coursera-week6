package forcomp

object sheet1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(71); val res$0 = 
  List("one","two","three","four").foldLeft("")((a,b) => a.concat(b) );System.out.println("""res0: String = """ + $show(res$0));$skip(62); val res$1 = 
  List("one","two","three","four").foldLeft("")(_.concat(_) );System.out.println("""res1: String = """ + $show(res$1));$skip(362); 
           
  def remove2(forRemoval: List[Char], word : List[Char]):List[Char] =
{
  
 word match
 {
  case x if forRemoval.isEmpty => word
  case head::tail if word.exists((c) => c == head) => remove2 (forRemoval.tail, word.tail)
  case head::tail if !word.exists((c) => c == head) =>  List(head) ++ remove2(forRemoval.tail, word.tail)
  case Nil => Nil
 }

};System.out.println("""remove2: (forRemoval: List[Char], word: List[Char])List[Char]""");$skip(40); 

        
   
   val word = "advantage";System.out.println("""word  : String = """ + $show(word ));$skip(16); 
   val rem = "";System.out.println("""rem  : String = """ + $show(rem ));$skip(40); val res$2 = 
   
   remove2(rem.toList, word.toList);System.out.println("""res2: List[Char] = """ + $show(res$2));$skip(258); 
   
   
       def generateList(stem:String, word :String ):List[List[Char]] =
    {
      word.toList match
      {
        case head::tail => List (stem.toList ::: List[Char](head)) ::: generateList(stem,word.tail)
        case Nil => List()
      }
    };System.out.println("""generateList: (stem: String, word: String)List[List[Char]]""");$skip(32); val res$3 = 
    
    generateList("","123");System.out.println("""res3: List[List[Char]] = """ + $show(res$3));$skip(37); 
    
    val evens = List(1,3,5,7,9);System.out.println("""evens  : List[Int] = """ + $show(evens ));$skip(28); 
val odds  = List(0,2,4,6,8);System.out.println("""odds  : List[Int] = """ + $show(odds ));$skip(78); val res$4 = 


odds.foldLeft(List[(Int,Int)]())((i1, i2) => i1 ::: evens.map((i)=>(i,i2)));System.out.println("""res4: List[(Int, Int)] = """ + $show(res$4));$skip(163); 


def allSubsets (occs : (Char, Int)) : List[(Char,Int)]
=
{
  occs._2 match
  {
     case 0 => Nil
     case _ => occs :: allSubsets((occs._1,occs._2 - 1))
  }
}

type Occurrences = List[(Char, Int)];System.out.println("""allSubsets: (occs: (Char, Int))List[(Char, Int)]""");$skip(71); 

val list1 = allSubsets(('a',4));System.out.println("""list1  : List[(Char, Int)] = """ + $show(list1 ));$skip(33); 

val list2 = allSubsets(('b',3));System.out.println("""list2  : List[(Char, Int)] = """ + $show(list2 ));$skip(33); 

val list5 = allSubsets(('c',1));System.out.println("""list5  : List[(Char, Int)] = """ + $show(list5 ));$skip(230); 
//list1.foldLeft(List[List[(Char,Int)]]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a)))
val listx = (list1.foldLeft(List[Occurrences]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a))) ) :::list2.map(List(_));System.out.println("""listx  : List[List[(Char, Int)]] = """ + $show(listx ));$skip(32); 

val occs = List[Occurrences]();System.out.println("""occs  : List[List[(Char, Int)]] = """ + $show(occs ));$skip(199); 

def xyz (existingOccs: List[Occurrences], newOccs : Occurrences):List[Occurrences] =
{
newOccs.foldLeft(List[Occurrences]())((acc,foldItem)=> existingOccs.map((count) =>count ::: List(foldItem)))
};System.out.println("""xyz: (existingOccs: List[forcomp.sheet1.Occurrences], newOccs: forcomp.sheet1.Occurrences)List[forcomp.sheet1.Occurrences]""");$skip(59); val res$5 = 

xyz(List[Occurrences](List(('a',1))),allSubsets(('b',3)));System.out.println("""res5: List[forcomp.sheet1.Occurrences] = """ + $show(res$5));$skip(248); 

  def getAllSubsets(list1:List[(Char,Int)],occNew:(Char,Int)):List[List[(Char,Int)]] =
{
 val list2 = allSubsets(occNew)
(list1.foldLeft(List[List[(Char,Int)]]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a))) ) :::list2.map(List(_))
 };System.out.println("""getAllSubsets: (list1: List[(Char, Int)], occNew: (Char, Int))List[List[(Char, Int)]]""");$skip(59); 
     val list4 = getAllSubsets(List[(Char,Int)](),('b',2));System.out.println("""list4  : List[List[(Char, Int)]] = """ + $show(list4 ));$skip(59); 
     val list3 = getAllSubsets(List[(Char,Int)](),('b',2));System.out.println("""list3  : List[List[(Char, Int)]] = """ + $show(list3 ))}
}
