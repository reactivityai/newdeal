package ai.reactivity.newdeal

import org.scalatest.FunSuite

import Entry._

class OrderBookTest extends FunSuite {
  test("inserting into empty book") {
    val book = OrderBook.empty('TEST)
    val newBook = book + Entry.bid(1.5, 200)
    assert(newBook.bids.length === 1)
    val refBook = OrderBook('TEST, -1.5|200)
    assert(newBook === refBook)
  }

  test("insertion order") {
    val bids = List(-1.5|200, -1.4|50, -1.4|100, -1.3|600)
    val offers = List(1.6|50, 1.7|100, 1.9|50, 2.0|58, 2.0|42)
    val book = OrderBook('TEST, -1.4|50, 2.0|58, 1.9|50, -1.4|100, -1.3|600, -1.5|200,  2.0|42, 1.6|50, 1.7|100)
    assert(book.bids == bids)
    assert(book.offers == offers)
  }

  test("Literal syntax") {
    val e = -4.5|300
    assert(e === Entry.bid(4.5, 300))
  }
}
