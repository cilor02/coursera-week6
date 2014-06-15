package forcomp

object sheet2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet 2");$skip(163); 
  def allSubsets (occs : (Char, Int)) : List[(Char,Int)]
=
{
  occs._2 match
  {
     case 0 => Nil
     case _ => occs :: allSubsets((occs._1,occs._2 - 1))
  }
}
  
  type Occurrences = List[(Char, Int)];System.out.println("""allSubsets: (occs: (Char, Int))List[(Char, Int)]""");$skip(75); 

val list1 = allSubsets(('a',4));System.out.println("""list1  : List[(Char, Int)] = """ + $show(list1 ));$skip(33); 

val list2 = allSubsets(('b',3));System.out.println("""list2  : List[(Char, Int)] = """ + $show(list2 ));$skip(33); 

val list5 = allSubsets(('c',1));System.out.println("""list5  : List[(Char, Int)] = """ + $show(list5 ));$skip(307); 
//list1.foldLeft(List[List[(Char,Int)]]()) ((acc,a)=> acc ::: list2.map((pair) => pair :: List(a)))


def xyz (existingOccs: List[Occurrences], newOccs : Occurrences):List[Occurrences] =
{
newOccs.foldLeft(List[Occurrences]())((acc,foldItem)=> acc::: existingOccs.map((count) =>count ::: List(foldItem)))
};System.out.println("""xyz: (existingOccs: List[forcomp.sheet2.Occurrences], newOccs: forcomp.sheet2.Occurrences)List[forcomp.sheet2.Occurrences]""");$skip(80); val res$0 = 

xyz(
xyz(List[Occurrences](List()),allSubsets(('b',3)))
,allSubsets(('c',4))
);System.out.println("""res0: List[forcomp.sheet2.Occurrences] = """ + $show(res$0));$skip(311); 
def findAllSubsets(occs:Occurrences):List[Occurrences] =
{

def findAllSubsetsAcc (occs:Occurrences, acc:List[Occurrences]):List[Occurrences] =
{
occs match
{
case Nil => acc
case (head::tail) => findAllSubsetsAcc(tail ,acc::: xyz(acc,allSubsets(head)))
}
}
findAllSubsetsAcc(occs, List[Occurrences](List()))
};System.out.println("""findAllSubsets: (occs: forcomp.sheet2.Occurrences)List[forcomp.sheet2.Occurrences]""");$skip(39); val res$1 = 
                  
findAllSubsets(Nil);System.out.println("""res1: List[forcomp.sheet2.Occurrences] = """ + $show(res$1));$skip(441); 

  def subtract(x: Occurrences, y: Occurrences): Occurrences =
  {
   x match
    {
      case _ if y == Nil => x
      case Nil => Nil
      case head::tail =>
        val newHead = y.foldLeft(head)((a,b)=>{ if(b._1 == head._1) (head._1,(head._2 - b._2))else a})
        
        if(newHead._2 == 0)
        {
          subtract(x.tail,y)
        }
        else
        {
          newHead::subtract(x.tail,y)
        }
         
    }
  };System.out.println("""subtract: (x: forcomp.sheet2.Occurrences, y: forcomp.sheet2.Occurrences)forcomp.sheet2.Occurrences""");$skip(72); val res$2 = 
 subtract (List(('a',4),('b',5),('c',2)),List(('a',2),('b',5),('c',1)));System.out.println("""res2: forcomp.sheet2.Occurrences = """ + $show(res$2));$skip(225); 
   def isSubtractable(x: Occurrences, y: Occurrences): Boolean =
  {
   y match
    {
     case Nil => true
     case head::tail => x.exists((t) => {t._1 == head._1 && t._2 >= head._2}) && isSubtractable(x,y.tail);
    }
  };System.out.println("""isSubtractable: (x: forcomp.sheet2.Occurrences, y: forcomp.sheet2.Occurrences)Boolean""");$skip(78); val res$3 = 
  isSubtractable(List(('a',4),('b',5),('c',2)),List(('a',2),('b',5),('c',1)))
 type Word = String;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(261); 
 
  def permutate (acc:List[List[Word]], words:List[Word]): List[List[Word]] =
  {
     words match
     {
       case Nil => Nil
       case head::tail => acc.foldLeft(List(head))((x,y) => x ::: y ) :: permutate (acc,words.tail)
     }
  };System.out.println("""permutate: (acc: List[List[forcomp.sheet2.Word]], words: List[forcomp.sheet2.Word])List[List[forcomp.sheet2.Word]]""");$skip(199); 
  
  def processWords(wordList:List[List[Word]]): List[List[Word]] =
  {
    wordList match
    {
      case Nil => Nil
      case head::tail => processWords(permutate(wordList.tail,head))
    }
  };System.out.println("""processWords: (wordList: List[List[forcomp.sheet2.Word]])List[List[forcomp.sheet2.Word]]""");$skip(24); 
 val ab = List("a","b");System.out.println("""ab  : List[String] = """ + $show(ab ));$skip(20); 
 val c  = List("c");System.out.println("""c  : List[String] = """ + $show(c ));$skip(31); 
 val deF  = List ("d","e","F");System.out.println("""deF  : List[String] = """ + $show(deF ));$skip(25); 
 val d  = List(ab,c,deF);System.out.println("""d  : List[List[String]] = """ + $show(d ));$skip(21); 
 val listC = List(c);System.out.println("""listC  : List[List[String]] = """ + $show(listC ));$skip(298); val res$4 = 

//permutate(permutate (List(List("Zulu"), List("Rex")), List("Lin", "nil")), deF)
//List(List("Zulu"), List("Rex"), List("Lin", "nil")).foldLeft(List[List[Word]]())((x,y)=>permutate(x,y))
//processWords(List(List("Zulu"), List("Rex"), List("Lin", "nil")))
 
List("Lin", "nil").map(_::List("Rex"));System.out.println("""res4: List[List[String]] = """ + $show(res$4));$skip(39); val res$5 = 
List("Rex").map(_::List("Lin", "nil"));System.out.println("""res5: List[List[String]] = """ + $show(res$5));$skip(61); val res$6 = 
List("Rex").map(_::List("Lin", "nil")).map(_:::List("Zulu"));System.out.println("""res6: List[List[String]] = """ + $show(res$6))}
 /*
      println( for{
        
        AB <- ab
        C <- c
        DEF <- deF
      } yield List(ab):::List(c):::List(DEF))
 */
 //List(ab,c,deF).foldLeft(List[List[List[String]]]()) ((a,b) => b.map((e)=> a :: List(e))
// d.foldLeft(List[String]()) ((a,b) => b.map((e)=> a :: e))
 
 
}
