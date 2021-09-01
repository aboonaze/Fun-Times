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
	 maxRetry = 20
	forloop (i=0; i<maxRetry; i++){
    try {
        timeout(time: 10, unit: 'SECONDS') {
            waitForQualityGate()
        }
    } catch(Exception e) {
        if (i == maxRetry-1) {
            throw e
        }
    }
}
       
  }
	
}
}
}