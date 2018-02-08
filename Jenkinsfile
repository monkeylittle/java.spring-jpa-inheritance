pipeline {
    agent any
    triggers {
        pollSCM('*/1 * * * *')
    }
    tools {
        jdk 'Java SE Development Kit 8'
        maven 'M3'
    }
    stages {
        stage('Code Commit') {
            steps {
                sh 'mvn clean package'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Build Stage..'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
        stage('Test') {
            failFast false
            parallel {
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
