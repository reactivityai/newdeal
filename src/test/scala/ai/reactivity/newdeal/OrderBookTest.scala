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
    val book = OrderBook('TEST, -1.4|50, -1.4|100, -1.3|600, -1.5|200)
    assert(book.bids == bids)
  }

  test("Literal syntax") {
    val e = -4.5|300
    assert(e === Entry.bid(4.5, 300))
  }
}
