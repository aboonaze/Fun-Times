pipeline {
  agent any
  stages {
  
    stage ('Build') {
        steps {
          script {                          
			call mvn clean install
          }
        }
    }
    
  }

}
