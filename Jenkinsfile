pipeline {
    agent any

    stages {

        stage('Environment') {
            steps {
                bat '''
                    echo ===== JAVA VERSION =====
                    java -version

                    echo ===== MAVEN VERSION =====
                    mvn -version
                '''
            }
        }

        stage('Run Playwright Tests') {
            steps {
                bat '''
                    echo ===== RUNNING PLAYWRIGHT TESTS =====
                    call mvn clean test
                '''
            }
        }
    }

    post {
        always {
            echo '===== BUILD COMPLETED ====='
        }

        success {
            echo '===== PLAYWRIGHT TESTS PASSED ====='
        }

        failure {
            echo '===== PLAYWRIGHT TESTS FAILED ====='
        }
    }
}