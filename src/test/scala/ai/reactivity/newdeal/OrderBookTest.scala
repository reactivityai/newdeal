package ai.reactivity.newdeal

import org.scalatest.FunSuite

import Entry._

class OrderBookTest extends FunSuite {
  test("inserting into empty book") {
    val book = OrderBook.empty('BTCUSD)
    val newBook = book + Entry.bid(1.5, 200)
    assert(newBook.bids.length === 1)
    val refBook = OrderBook('BTCUSD, -1.5|200)
    assert(newBook === refBook)
  }

  test("Literal syntax") {
    val e = -4.5|300
    assert (e === Entry.bid(4.5, 300))
  }
}
