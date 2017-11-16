package sbtstudent

/**
  * Copyright © 2014, 2015, 2016 Lightbend, Inc. All rights reserved. [http://www.typesafe.com]
  */
import sbt.Keys._
import sbt._

import scala.Console

object Navigation {

  val setupNavAttrs: (State) => State = (state: State) => state

  val loadBookmark: (State) => State = (state: State) => {
    // loadBookmark doesn't really load a bookmark for a master repo.
    // It just selects the first exercise (project) from the repo
    val refs =
    Project.extract(state)
      .structure
      .allProjectRefs
      .toList
      .map(r => r.project)
      .filter(_.startsWith("exercise_"))
      .sorted

    refs.headOption.map { h =>
      Command.process(s"project $h", state)
    }.getOrElse(state)
//    state
  }
}
