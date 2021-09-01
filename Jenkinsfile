pipeline {
  agent any
  stages {
  steps{
  stage('build') {
      cmd_exec('echo "Buils starting..."')
      cmd_exec('mvn install')
	}
 
  def cmd_exec(command) {
    return bat(returnStdout: true, script: "${command}").trim()
	}
	}

}


