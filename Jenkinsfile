pipeline {
    agent any
    tools {
        maven 'Maven Jenkins'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/aditbagja/xmart-be-spring']])
                sh 'mvn clean install' // use sh for Linux OS, use bat for Windows OS
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package'
                    sh ''' mvn clean verify sonar:sonar -Dsonar.projectKey=xmart-be-spring -Dsonar.projectName='xmart-be-spring' -Dsonar.host.url=http://localhost:9000 '''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }

    }
}