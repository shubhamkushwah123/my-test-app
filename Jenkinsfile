node{
    stage("git checkout"){
        git credentialsId: '98d55b2e-8180-4638-8759-832fa91a1f87', url: 'https://github.com/shubhamkushwah123/my-test-app.git'
    }
    
    stage("maven build"){
        tool name: 'MAVEN-3', type: 'maven'
        sh 'mvn clean package'
    }
    
    stage("Sonarqube scan"){
       sh 'mvn sonar:sonar'
    }
    
    stage("docker build image"){
        sh 'docker build -t shubhamkushwah123/my-test-app:1.0.0 .'
    }
    
    stage("push Docker image"){
        sh 'docker push shubhamkushwah123/my-test-app:1.0.0'
    }
    
    stage("run docker image"){
        sh 'docker run -p 8888:8888 -d --name my-test-app shubhamkushwah123/my-test-app:1.0.0'
    }
}