package ai.reactivity.newdeal

case class OrderBook private(symbol: Symbol, bids: List[Entry], offers: List[Entry]) {
  def +(entry: Entry): OrderBook = {
    if (entry.isBid) {
      val idx = bids.indexWhere(_.price > entry.price)
      val insert = if (idx == -1) bids.length else idx
      val newBids = bids.patch(insert, List(entry), 0)
      copy(bids = newBids)
    } else {
      val idx = bids.indexWhere(_.price > entry.price)
      val insert = if (idx == -1) offers.length else idx
      val newOffers = offers.patch(insert, List(entry), 0)
      copy(offers = newOffers)
    }
  }

}

object OrderBook {
  def empty(symbol: Symbol): OrderBook = OrderBook(symbol, Nil, Nil)

  def apply(symbol: Symbol, entries: Entry*): OrderBook = entries.foldLeft(empty(symbol))(_ + _)
}