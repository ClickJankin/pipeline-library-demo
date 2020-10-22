#!/usr/bin/env groovy

@NonCPS
def call(passedBuilds) {
  def log = ""
  for (int x = 0; x < passedBuilds.size(); x++) {
      def currentBuild = passedBuilds[x];
      def changeLogSets = currentBuild.rawBuild.changeSets
      for (int i = 0; i < changeLogSets.size(); i++) {
          def entries = changeLogSets[i].items
          for (int j = 0; j < entries.length; j++) {
              def entry = entries[j]
              log += "* ${entry.msg} by ${entry.author} "
          }
      }
  }
  return log;
}

