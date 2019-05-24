package ai.reactivity.newdeal

import ai.reactivity.newdeal.math.SafeDouble

case class OrderBook private(symbol: Symbol, bids: List[Entry], offers: List[Entry]) {
  def +(entry: Entry): OrderBook = {
    val line = if (entry.isBid) bids else offers
    val idx = line.indexWhere(_.price > entry.price)
    val insert = if (idx == -1) line.length else idx
    val newLine = line.patch(insert, List(entry), 0)
    if (entry.isBid) copy(bids = newLine) else copy(offers = newLine)
  }

  def removeByPrice(price: SafeDouble): OrderBook = {
    val line = if (price < 0) bids else offers
    val priceStart = line.indexWhere(_.price == price)
    if (priceStart == -1) this else {
      ???
    }
  }
}

object OrderBook {
  def empty(symbol: Symbol): OrderBook = OrderBook(symbol, Nil, Nil)

  def apply(symbol: Symbol, entries: Entry*): OrderBook = entries.foldLeft(empty(symbol))(_ + _)
}