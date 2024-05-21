pipeline {
    agent any
    tools {
        maven 'Maven Jenkins' // samakan dengan configurasi Name Maven di Jenkins
    }

    environment {
        BUILD_NUMBER_ENV = "${env.BUILD_NUMBER}"
        TEXT_SUCCESS_BUILD = "Build #${env.BUILD_NUMBER} is Success - Project Name: ${JOB_NAME}"
        TEXT_FAILURE_BUILD = "Build #${env.BUILD_NUMBER} is Failed - Project Name: ${JOB_NAME}"
    }

    stages {
        stage('Git Checkout') {
            steps {
                // checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/aditbagja/xmart-be-spring']])
                // sh 'mvn clean install' // gunakan sh untuk Linux OS, gunakan bat untuk Windows OS
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    // sh 'mvn clean package'
                    // sh ''' mvn clean verify sonar:sonar -Dsonar.projectKey=xmart-be-spring -Dsonar.projectName='xmart-be-spring' -Dsonar.host.url=http://localhost:9000 '''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }

    }
    post {
        success {
            script {
                withCredentials([string(credentialsId: 'telegram-token', variable: 'TOKEN'), string(credentialsId: 'chat-id', variable: 'CHAT_ID')]) {
                    // sh ''' curl -s -X POST https://api.telegram.org/bot%TOKEN%/sendMessage -d chat_id="%CHAT_ID%" -d text="%TEXT_SUCCESS_BUILD%" '''
                    echo "Telegram Token is %TOKEN%. Chat Id is %CHAT_ID. Text Success is %TEXT_SUCCESS_BUILD%"
                }
            }
        }
        failure {
            script {
                withCredentials([string(credentialsId: 'telegram-token', variable: 'TOKEN'), string(credentialsId: 'chat-id', variable: 'CHAT_ID')]) {
                    // sh ''' curl -s -X POST https://api.telegram.org/bot%TOKEN%/sendMessage -d chat_id="%CHAT_ID%" -d text="%TEXT_FAILURE_BUILD%" '''
                    echo "Telegram Token is %TOKEN%. Chat Id is %CHAT_ID. Text Success is %TEXT_FAILURE_BUILD%"
                }
            }
        }
    }
}