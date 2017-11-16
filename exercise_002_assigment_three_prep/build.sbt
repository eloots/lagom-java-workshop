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


lazy val `inventory-api` = project("inventory-api")
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lombok
    )
  )


lazy val `inventory-impl` = project("inventory-impl")
  .enablePlugins(LagomJava)
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomJavadslTestKit,
      lagomJavadslJackson,
      lombok
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`inventory-api`)

val lombok = "org.projectlombok" % "lombok" % "1.16.10"

def common = Seq(
  javacOptions in compile += "-parameters"
)


aggregateProjects(`basket-api`, `basket-impl`, `inventory-api`, `inventory-impl`)
