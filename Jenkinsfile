
pipeline {

    agent {
        label 'master'
    }

    environment {
        THIS_BUILD_NUMBER="?"
    }

    stages {
        
        stage('prep') {
            agent {
                label 'master'
            }
            
            steps {
                
                script {
                    checkout scm
                    
                    sh 'pwd'
                    sh 'ls'
                }
            }
        }
        
        stage('build') {
            agent { label 'master' }
            
            steps {
                sh 'mvn --version' //mvn clean package
                sh 'pwd'
                sh 'ls'
                sh 'mvn clean package'
            }
        }
        
        stage('stop') {
            agent any
            
            steps {
                echo 'stopping...'
                echo 'stopped!'
            }
        }
        
        stage('deploy') {
            agent any
            
            steps {
                timeout(time: 30, unit: 'SECONDS') {
                    sh 'echo deploying...'
                    //sh ''
                    sh 'echo Deployed!'
                }
            }
        }
        
        stage('results') {
            agent {
                label 'master'
            }
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archive 'target/*.jar'
            }
        }
    }
    
    
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
    
}

