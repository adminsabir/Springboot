pipeline {
    agent any
    environment {
        registryCredential = 'ecr:us-east-1:aws-creds'
        appRegistry = "210003706436.dkr.ecr.us-east-1.amazonaws.com/ribasdevops"
        profileRegistry = "https://210003706436.dkr.ecr.us-east-1.amazonaws.com"
    }
    stages {
        stage ("Fetch Code") {
            steps {
            git branch : 'Release', url: 'https://github.com/adminsabir/Springboot.git'
        }

        stage ("Testing") {
        steps {
            sh 'mvn test'
        }
        stage ("Build docker image") {
            steps {
                script {
                    dockerImage = docker.build (  appRegistry + ":$BUILD_NUMBER", "."
                }
            }
        }
        stage ("Upload docker in ECR") {
            steps {
                script {
                docker.withRegistry ( profileRegistry, registryCredential ) {
                docker.Image.push("$BUILD_NUMBER")
                docker.Image.push("latest")
                }
                }
            }

        }
    }


}