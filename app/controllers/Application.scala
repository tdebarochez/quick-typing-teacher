package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.util.Random

object Application extends Controller {

  def index = Action { request =>
    Ok(views.html.index(request.session.get("letter").getOrElse("")))
  }

  def letter = Action { request =>
    val letter: String = Random.nextPrintableChar().toString()
    Ok(Json.toJson(letter)).withSession("letter" -> letter)
  }

  def check(letter: String) = Action { request =>
    val sess_letter: String = request.session.get("letter").getOrElse("__")
    Ok(Json.toJson(letter.length() > 0 && sess_letter == letter.substring(0, 1)))
  }
}