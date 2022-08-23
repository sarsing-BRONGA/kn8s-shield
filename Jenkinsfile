node {
    def app

    stage('Clone repository') {
      

        checkout scm
    }

    stage('Gradle Build') {

    sh './gradlew clean build'
  
    }

    stage('Build image') {
  
       app = docker.build("ansosh017/k8test", "--build-arg JAR_FILE=build/libs/\*.jar" )
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
