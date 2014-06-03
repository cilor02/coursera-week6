package forcomp

object TestAnagram extends App
{

  println(Anagrams.wordOccurrences("waterstones"))
  println(Anagrams.sentenceOccurrences(List("water","stones")))
  
  println(Anagrams.dictionaryArranger(List("water","stones","rat","tar", "notes","stone","tones","sonet"), Map[Anagrams.Occurrences, List[String]]()))
}