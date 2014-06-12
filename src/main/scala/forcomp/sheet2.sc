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
  
}