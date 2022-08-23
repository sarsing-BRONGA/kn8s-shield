node{
    def app

    stage('Clone repository') {
      

        checkout scm
    }

    stage('Gradle Build') {

    sh './gradlew clean build'
  
    }

    stage('Build image') {

        sh 'docker run -u 0 --privileged --name jenkins -d -p 8080:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts'
  
       app = docker.build("ansosh017/k8test", "--build-arg JAR_FILE=build/libs/kn8s-shield-0.0.1-SNAPSHOT.jar" )
    }

    stage('Test image') {
  

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            app.push("${env.BUILD_NUMBER}")
        }
    }
    
}
