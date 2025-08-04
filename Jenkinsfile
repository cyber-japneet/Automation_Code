pipeline {
  agent any

  environment {
    // point at standalone Chrome mapped on port 4441
    SELENIUM_HUB_URL = 'http://chrome:4441/wd/hub'
  }

  stages {
    stage('Build & Test') {
      steps {
        script {
          // Use Maven 3.8.7 with OpenJDK 17
          docker.image('maven:3.8.7-openjdk-17').inside('--network test-net') {
            sh '''
              mvn clean test \
                -Dmode=docker -Dwebdriver.remote.url=${SELENIUM_HUB_URL}
            '''
          }
        }
      }
    }

    stage('Publish Results') {
      steps {
        // Publish TestNG report
        step([$class: 'TestNGPublisher', testResultsPattern: 'test-output/testng-results.xml'])
        // Archive built artifacts
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
  }
}
