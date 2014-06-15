package forcomp

object sheet2 {
  println("Welcome to the Scala worksheet 2")     //> Welcome to the Scala worksheet 2
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


def xyz (existingOccs: List[Occurrences], newOccs : Occurrences):List[Occurrences] =
{
newOccs.foldLeft(List[Occurrences]())((acc,foldItem)=> acc::: existingOccs.map((count) =>count ::: List(foldItem)))
}                                                 //> xyz: (existingOccs: List[forcomp.sheet2.Occurrences], newOccs: forcomp.sheet
                                                  //| 2.Occurrences)List[forcomp.sheet2.Occurrences]

xyz(
xyz(List[Occurrences](List()),allSubsets(('b',3)))
,allSubsets(('c',4))
)                                                 //> res0: List[forcomp.sheet2.Occurrences] = List(List((b,3), (c,4)), List((b,2)
                                                  //| , (c,4)), List((b,1), (c,4)), List((b,3), (c,3)), List((b,2), (c,3)), List((
                                                  //| b,1), (c,3)), List((b,3), (c,2)), List((b,2), (c,2)), List((b,1), (c,2)), Li
                                                  //| st((b,3), (c,1)), List((b,2), (c,1)), List((b,1), (c,1)))
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
}                                                 //> findAllSubsets: (occs: forcomp.sheet2.Occurrences)List[forcomp.sheet2.Occur
                                                  //| rences]
                  
findAllSubsets(Nil)                               //> res1: List[forcomp.sheet2.Occurrences] = List(List())

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
  }                                               //> subtract: (x: forcomp.sheet2.Occurrences, y: forcomp.sheet2.Occurrences)for
                                                  //| comp.sheet2.Occurrences
 subtract (List(('a',4),('b',5),('c',2)),List(('a',2),('b',5),('c',1)))
                                                  //> res2: forcomp.sheet2.Occurrences = List((a,2), (c,1))
   def isSubtractable(x: Occurrences, y: Occurrences): Boolean =
  {
   y match
    {
     case Nil => true
     case head::tail => x.exists((t) => {t._1 == head._1 && t._2 >= head._2}) && isSubtractable(x,y.tail);
    }
  }                                               //> isSubtractable: (x: forcomp.sheet2.Occurrences, y: forcomp.sheet2.Occurrenc
                                                  //| es)Boolean
  isSubtractable(List(('a',4),('b',5),('c',2)),List(('a',2),('b',5),('c',1)))
                                                  //> res3: Boolean = true
 type Word = String
 
  def permutate (acc:List[List[Word]], words:List[Word]): List[List[Word]] =
  {
     words match
     {
       case Nil => Nil
       case head::tail => acc.foldLeft(List(head))((x,y) => x ::: y ) :: permutate (acc,words.tail)
     }
  }                                               //> permutate: (acc: List[List[forcomp.sheet2.Word]], words: List[forcomp.sheet
                                                  //| 2.Word])List[List[forcomp.sheet2.Word]]
  
  def processWords(wordList:List[List[Word]]): List[List[Word]] =
  {
    wordList match
    {
      case Nil => Nil
      case head::tail => processWords(permutate(wordList.tail,head))
    }
  }                                               //> processWords: (wordList: List[List[forcomp.sheet2.Word]])List[List[forcomp.
                                                  //| sheet2.Word]]
 val ab = List("a","b")                           //> ab  : List[String] = List(a, b)
 val c  = List("c")                               //> c  : List[String] = List(c)
 val deF  = List ("d","e","F")                    //> deF  : List[String] = List(d, e, F)
 val d  = List(ab,c,deF)                          //> d  : List[List[String]] = List(List(a, b), List(c), List(d, e, F))
 val listC = List(c)                              //> listC  : List[List[String]] = List(List(c))

//permutate(permutate (List(List("Zulu"), List("Rex")), List("Lin", "nil")), deF)
//List(List("Zulu"), List("Rex"), List("Lin", "nil")).foldLeft(List[List[Word]]())((x,y)=>permutate(x,y))
//processWords(List(List("Zulu"), List("Rex"), List("Lin", "nil")))
 
List("Lin", "nil").map(_::List("Rex"))            //> res4: List[List[String]] = List(List(Lin, Rex), List(nil, Rex))
List("Rex").map(_::List("Lin", "nil"))            //> res5: List[List[String]] = List(List(Rex, Lin, nil))
List("Rex").map(_::List("Lin", "nil")).map(_:::List("Zulu"))
                                                  //> res6: List[List[String]] = List(List(Rex, Lin, nil, Zulu))
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