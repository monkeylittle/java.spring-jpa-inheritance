pipeline {
    agent any

    stages {
        stage('Code Commit') {
            steps {
                echo 'Code Commit Stage..'
                def mvnHome = tool 'MAVEN3'
                sh "${mvnHome}/bin/mvn clean install -DskipTests"
            }
        }
        stage('Build') {
            steps {
                echo 'Build Stage..'
            }
        }
        stage('Acceptance Test') {
            steps {
                echo 'Acceptance Test Stage....'
            }
        }
        stage('Performance Test') {
            steps {
                echo 'Performance Test Stage....'
            }
        }
        stage('Stability Test') {
            steps {
                echo 'Stability Test Stage....'
            }
        }
        stage('Exploratory Test') {
            steps {
                echo 'Exploratory Test Stage....'
            }
        }
        stage('Production') {
            steps {
                echo 'Production Stage....'
            }
        }
    }
}
