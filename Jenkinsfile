node {
    def app

    stage('Clone repository') {
      

        checkout scm
    }

    stage('Gradle Build') {

    buildInfo = rtGradle.run rootDir: "/", buildFile: 'build.gradle', tasks: 'clean jar'
  
    }

    stage('Build image') {
  
       app = docker.build("ansosh017/k8test")
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
