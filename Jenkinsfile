pipeline {
  agent any
   tools { 
        maven 'Maven 3.8.1' 
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