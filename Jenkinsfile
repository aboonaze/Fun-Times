pipeline {
  agent any
   tools { 
        maven 'maven',
		maven 'sonar'
  }
  stages {
  stage('build') {
  
  steps{
      bat """
    mvn clean install
    
  """
  bat """
    mvn sonar:sonar \
  -Dsonar.projectKey=dex \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=d5abb5184fa2ab28b14843d610734490493d9bd4
    
  """
  }
	}
	
}
}