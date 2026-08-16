pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Users\\Tiaa User\\AppData\\Local\\Programs\\Eclipse Adoptium\\jdk-21.0.11.10-hotspot'
        MAVEN_HOME = 'C:\\Users\\Tiaa User\\Tools\\apache-maven-3.9.16'
        PATH = "${JAVA_HOME}\\bin;${MAVEN_HOME}\\bin;${env.PATH}"
    }

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

post {
    always {
        echo '===== BUILD COMPLETED ====='

        allure([
            includeProperties: false,
            jdk: '',
            results: [[path: 'allure-results']]
        ])
    }

    success {
        echo '===== PLAYWRIGHT TESTS PASSED ====='
    }

    failure {
        echo '===== PLAYWRIGHT TESTS FAILED ====='
    }
}