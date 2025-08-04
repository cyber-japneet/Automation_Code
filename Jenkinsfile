pipeline {
  // Use a dedicated Docker container as the build agent
  agent {
    docker {
      image 'maven:3.8.7-openjdk-17'
      // Join the Compose network and mount Docker socket if you need to call docker CLI
      args '--network test-net -v /var/run/docker.sock:/var/run/docker.sock'
    }
  }

  environment {
    // Standalone Chrome mapped on port 4441
    SELENIUM_HUB_URL = 'http://chrome:4441/wd/hub'
  }

  stages {
    stage('Build & Test') {
      steps {
        // Inside the Maven container, just run the Maven goal directly
        sh """
          mvn clean test \
            -Dwebdriver.remote.url=${SELENIUM_HUB_URL}
        """
      }
    }

    stage('Publish Results') {
      steps {
        // Publish TestNG reports
        step([
          $class: 'TestNGPublisher',
          testResultsPattern: 'test-output/testng-results.xml'
        ])
        // Archive your artifacts
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
  }
}
