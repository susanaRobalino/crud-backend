pipeline {
    agent any
    environment {
        SONAR_SCANNER_HOME = tool 'SonarQube Scanner'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/susanaRobalino/crud-backend.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package' // Si usas Maven, ajusta según tu proyecto
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 1, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }
}
