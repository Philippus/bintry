package bintry

import dispatch._
import com.ning.http.client.RequestBuilder

sealed trait Credentials {
  def sign(req: RequestBuilder): RequestBuilder
}

case class BasicAuth(user: String, pass: String) extends Credentials {
  def sign(req: RequestBuilder) =
    req.as_!(user, pass)
}
