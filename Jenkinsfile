pipeline {
    agent any
    tools {
        jdk 'java21'
        maven 'Maven3'
    }
    environment {
        registryCredential = 'ecr:us-east-1:awscreds'
        appRegistry = "210003706436.dkr.ecr.us-east-1.amazonaws.com/ribasdevops"
        profileRegistry = "https://210003706436.dkr.ecr.us-east-1.amazonaws.com"
    }
    stages {
        stage ('Fetch Code') {
            steps {
            git branch : 'Release', url: 'https://github.com/adminsabir/Springboot.git'
           }
        }

         stage ('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Build docker image') {
            steps {
                script {
                    //sh 'docker-compose up --build -d'
                    dockerImage = docker.build ( appRegistry + ":$BUILD_NUMBER", ".")
                }
            }
        }

        stage ('Upload docker in ECR') {
            steps {
                script {
                    docker.withRegistry ( profileRegistry, registryCredential ) {
                    dockerImage.push("$BUILD_NUMBER")
                    dockerImage.push('latest')
                    }
                }
            }

        }
    }
}