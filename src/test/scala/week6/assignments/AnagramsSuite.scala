package week6.assignments

import org.scalatest.FunSuite

import Anagrams._

class AnagramsSuite extends FunSuite {

  test("wordOccurrences: abcd (3pts)") {
    assert(
      wordOccurrences("abcd") == List(('a', 1), ('b', 1), ('c', 1), ('d', 1))
    )
  }

  test("wordOccurrences: Robert (3pts)") {
    assert(
      wordOccurrences("Robert") == List(
        ('b', 1),
        ('e', 1),
        ('o', 1),
        ('r', 2),
        ('t', 1)
      )
    )
  }

  test("sentenceOccurrences: abcd e (5pts)") {
    assert(
      sentenceOccurrences(List("abcd", "e")) == List(
        ('a', 1),
        ('b', 1),
        ('c', 1),
        ('d', 1),
        ('e', 1)
      )
    )
  }

  test("dictionaryByOccurrences.get: eat (10pts)") {
    assert(
      dictionaryByOccurrences
        .get(List(('a', 1), ('e', 1), ('t', 1)))
        .map(_.toSet)
        == Some(Set("ate", "eat", "tea"))
    )
  }

  test("wordAnagrams married (2pts)") {
    assert(wordAnagrams("married").toSet == Set("married", "admirer"))
  }

  test("wordAnagrams player (2pts)") {
    assert(
      wordAnagrams("player").toSet == Set(
        "parley",
        "pearly",
        "player",
        "replay"
      )
    )
  }

  test("subtract: lard - r (10pts)") {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val r = List(('r', 1))
    val lad = List(('a', 1), ('d', 1), ('l', 1))
    assert(subtract(lard, r) == lad)
  }

  test("combinations: [] (8pts)") {
    assert(combinations(Nil) == List(Nil))
  }

  test("combinations: abba (8pts)") {
    val abba = List(('a', 2), ('b', 2))
    val abbacomb = List(
      List(),
      List(('a', 1)),
      List(('a', 2)),
      List(('b', 1)),
      List(('a', 1), ('b', 1)),
      List(('a', 2), ('b', 1)),
      List(('b', 2)),
      List(('a', 1), ('b', 2)),
      List(('a', 2), ('b', 2))
    )
    assert(combinations(abba).toSet == abbacomb.toSet)
  }

  test("sentence anagrams: [] (10pts)") {
    val sentence = List()
    assert(sentenceAnagrams(sentence) == List(Nil))
  }

  test("sentence anagrams: Linux rulez (10pts)") {
    val sentence = List("Linux", "rulez")
    val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )
    assert(sentenceAnagrams(sentence).toSet == anas.toSet)
  }

}
