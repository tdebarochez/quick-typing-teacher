import sbt._
import Keys._
import play.Project._
import net.litola.SassPlugin

object ApplicationBuild extends Build {

  val appName         = "quick-typing-teacher"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    SassPlugin.sassSettings(0),
    SassPlugin.sassOptions := Seq("--compass", "-r", "compass"),
    SassPlugin.sassSettings(2)
  )

}
