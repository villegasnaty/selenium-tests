pipeline {
    agent any
     
        stage('Build') {
            steps {

                sh 'mvn clean verify -Dbrowser=chrome'
     
            }
        }
}

