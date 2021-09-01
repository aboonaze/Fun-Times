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
	stage('sonar build') {
  
  steps{
     withSonarQubeEnv(installationName: 'sonarcube', credentialsId: 'sonar_token') {
                bat """
				mvn clean package sonar:sonar
				 """
                }
  }
	}
	stage('SQuality Gate') {
     steps {
		sleep(10)
       timeout(time: 1, unit: 'MINUTES') {
       waitForQualityGate abortPipeline: true
       }
  }
	
}
}
}