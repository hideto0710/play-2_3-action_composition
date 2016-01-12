name := """play-2_3-action_composition"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).addPlugins(PlayScala)

fork in run := true