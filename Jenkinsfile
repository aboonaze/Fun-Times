pipeline {
  agent any
  tools { 
        maven 'Maven 3.8.1' 
  }
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
