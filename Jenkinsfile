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
                sh 'mvn package'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn verify'
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
            post {
                success {
                    input message: "Promote to exploratory test environment?"
                }
            }
        }
        stage('Exploratory Test') {
            steps {
                echo 'Exploratory Test Stage....'
            }
            post {
                success {
                    input message: "Promote to production environment?"
                }
            }
        }
        stage('Production') {
            steps {
                echo 'Production Stage....'
            }
        }
    }
}
