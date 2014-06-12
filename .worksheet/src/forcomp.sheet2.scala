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
                  
findAllSubsets(Nil);System.out.println("""res1: List[forcomp.sheet2.Occurrences] = """ + $show(res$1))}
  
}
