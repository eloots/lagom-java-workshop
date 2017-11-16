
lazy val base = (project in file("."))
  .aggregate(
    common,
    exercise_000_assignment_one,
    exercise_001_assignment_two,
    exercise_002_assigment_three_prep,
		exercise_003_assignment_three
 )
  .settings(CommonSettings.commonSettings: _*)


lazy val common = project.settings(CommonSettings.commonSettings: _*)

lazy val exercise_000_assignment_one = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")

lazy val exercise_001_assignment_two = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")

lazy val exercise_002_assigment_three_prep = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")

lazy val exercise_003_assignment_three = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")
