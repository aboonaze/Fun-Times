pipeline {
  agent any
   tools { 
        maven 'maven' 
  }
  stages {
  stage('build') {
  
  steps{
      bat """
    mvn clean install
    
  """
  }
	}
	
}
}