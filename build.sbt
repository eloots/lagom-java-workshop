
lazy val base = (project in file("."))
  .aggregate(
    common,
    exercise_000_assignment
 )
  .settings(CommonSettings.commonSettings: _*)


lazy val common = project.settings(CommonSettings.commonSettings: _*)

lazy val exercise_000_assignment = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")
