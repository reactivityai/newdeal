package ai.reactivity.newdeal

import ai.reactivity.newdeal.math.SafeDouble

case class Entry private(price: SafeDouble, amount: SafeDouble, id: Option[Symbol]) {

  require(price.toDouble != 0.0)

  lazy val isBid: Boolean = price < 0
  lazy val isOffer: Boolean = price > 0

  lazy val absPrice: SafeDouble = price.toDouble.abs
}

object Entry {
  def bid(price: SafeDouble, amount: SafeDouble, id: Option[Symbol] = None) = Entry(-price.toDouble.abs, amount, id)
  def offer(price: SafeDouble, amount: SafeDouble, id: Option[Symbol] = None) = Entry(price.toDouble.abs, amount, id)

  implicit class DoubleImplicits(value: Double) {
    def |(amountDbl: Double): Entry = {
      Entry(value, amountDbl, None)
    }
  }
}
