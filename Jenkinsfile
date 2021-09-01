pipeline {
  agent any
  stages {
  
    stage ('Build') {
        steps {
          script {                          
           sh 'mvn -Dmaven.test.failure.ignore=true -Dintegration-tests.skip=true -Dmaven.test.skip=true clean package'                              
          }
        }
    }
    
  }

}
