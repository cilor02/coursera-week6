package forcomp

//import scala.collection.mutable.ListBuffer

object TestAnagram extends App
{

  //println(Anagrams.wordOccurrences("waterstones"))
  //println(Anagrams.sentenceOccurrences(List("water","stones")))
  
  //println(Anagrams.dictionaryArranger(List("water","stones","rat","tar", "notes","stone","tones","sonet"), Map[Anagrams.Occurrences, List[String]]()))

  //println(Anagrams.generateAnagramList(List[List[Char]](List(' ')) , "war".toList, List[List[Char]](List(' '))))
  //println(Anagrams.findAnagrams("bc", List[Anagrams.Word]("a")))
  //println(Anagrams.wordAnagrams("file"))
  //Anagrams.Anans(Anagrams.sentenceOccurrences(List("i", "love","you")), List[Anagrams.Occurrences](), List[List[Anagrams.Occurrences]]())
    //Anagrams.Anans(Anagrams.sentenceOccurrences(List("Linux", "rulez")), List[Anagrams.Occurrences](), List[List[Anagrams.Occurrences]]())
      //Anagrams.useUseAnans(Anagrams.useAnans(Anagrams.sentenceOccurrences(List("Linux", "rulez")))).foreach (println)
      val grams = Anagrams.useUseAnans(Anagrams.sentenceOccurrences(List("Linux", "rulez")))
//val zulu = List(List("Zulu"), List("Rex"), List("Lin", "nil")).foldLeft(List[List[String]]())((x,y)=>Anagrams.permutate(x,y))
//println(zulu)

//val zulu2 = Anagrams.processWords(List(List("Zulu"), List("Lin", "nil"), List("Rex")))
//println(zulu2)
//grams foreach println

//Anagrams.zzzzzz(List(List("Zulu"), List("Lin", "nil"), List("Rex")), List[String](),ListBuffer[List[String]]())
//println
//Anagrams.usePermutate(grams).foreach(println)
      
      //grams.map ((z) => z.foldLeft(List(z.head))())
//var z = ListBuffer[List[String]]()
//Anagrams.useSideEffects(grams,z)

//(z toList).foreach( println)

println(Anagrams.sentenceAnagrams(List()))
}