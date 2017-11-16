organization in ThisBuild := "com.example"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.8"

def project(id: String) = Project(id, base = file(id))

lazy val `basket-api` = project("basket-api")
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lombok
    )
  )

lazy val `basket-impl` = project("basket-impl")
  .enablePlugins(LagomJava)
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslTestKit,
      lagomJavadslJackson,
      lombok
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`basket-api`)

val lombok = "org.projectlombok" % "lombok" % "1.16.10"

def common = Seq(
  javacOptions in compile += "-parameters"
)

