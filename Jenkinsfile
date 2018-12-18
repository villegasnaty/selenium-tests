pipeline {
    agent any
     stages {
        stage('Run local container') {
                  agent any
                  steps {
                    sh 'docker rm -f pet-clinic || true'
                    sh 'docker run -d -p 8081:8080 --name pet-clinic natyramone/pet-clinic:latest'
                  }
                }
                stage('Build') {
                            steps {

                                sh 'mvn clean verify -Dbrowser=chrome'

                            }
                        }
    }
}

