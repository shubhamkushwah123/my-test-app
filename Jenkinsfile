node{
    stage("git checkout"){
        git credentialsId: '98d55b2e-8180-4638-8759-832fa91a1f87', url: 'https://github.com/shubhamkushwah123/my-test-app.git'
    }
    
    stage("maven build"){
       def mvnHome = tool name: 'MAVEN-3', type: 'maven'
       def mvnCMD = "$(mvnHome)/bin/mvn"    
        sh "$(mvnCMD) clean package"
    }
    
    stage("Sonarqube scan"){
       sh 'mvn sonar:sonar'
    }
   
	
    stage("mvn package")
	
    
    stage("docker build image"){
        sh 'docker build -t shubhamkushwah123/my-test-app:1.0.0 .'
    }
    
    stage("push Docker image"){
    withCredentials([string(credentialsId: 'dockerPwd', variable: 'dockerHubPwd')]) {
       sh "docker login -u shubhamkushwah123 -p ${dockerHubPwd}"
     }
     sh 'docker push shubhamkushwah123/my-test-app:1.0.0'
     
    }
    
    stage("run on aws server"){
    
        def dockerRun = 'docker run -p 80:8888 -d --name my-test-app shubhamkushwah123/my-test-app:1.0.0'
        
        sshagent(['dev-server']) {
   		 sh "ssh -o StrictHostKeyChecking=no ec2-user@52.49.111.14 ${dockerRun}"
		}
    }
}
