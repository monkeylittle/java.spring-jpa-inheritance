pipeline {
    agent any

    stages {
        stage('Code Commit') {
            steps {
                echo 'Code Commit Stage..'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:monkeylittle/spring-jpa-inheritance.git']]])
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
