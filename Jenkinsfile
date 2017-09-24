pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building'
            }
        }
      stage('Test') {
            steps {
                echo 'Running Unit Test'
                step{
                    echo 'test on area 1'

                step{
                    echo 'test on area 2'
                }
            }
        }
      stage('Upload Artifacts') {
            steps {
                echo 'Upload Artifacts to Nexus'
            }
        }
      stage('Deploy') {
            steps {
                echo 'Stop App with port 5000'
                echo 'Deploy App with port 5000'
            }
        }
    }
}