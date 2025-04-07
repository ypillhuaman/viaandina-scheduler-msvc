pipeline {
    agent any

    parameters {
        credentials(name: 'DOCKER_CREDENTIALS', description: 'Docker Hub credentials')
        string(name: 'SONAR_URL', description: 'Sonar URL', defaultValue: 'http://sonarqube:9000')
        string(name: 'SONAR_TOKEN', description: 'Sonar token')
        string(name: 'ENVIRONMENT', description: 'Environment', defaultValue: 'dev')
    }

    environment {
        SERVICE_NAME = 'viand-scheduler-msvc'
        IMAGE_NAME = 'yurigrow/viand-scheduler-msvc'
        IMAGE_TAG = 'latest'
        DOCKER_COMPOSE_PATH = '/mnt/docker-compose'
    }

    stages {

        stage('Validar Parámetros') {
            steps {
                script {
                    if (!params.DOCKER_CREDENTIALS?.trim()) {
                        error("Parámetro DOCKER_CREDENTIALS es requerido pero está vacío.")
                    }
                    if (!params.SONAR_TOKEN?.trim()) {
                        error("Parámetro SONAR_TOKEN es requerido pero está vacío.")
                    }
                }
            }
        }

        stage('Análisis con SonarQube') {
            steps {
                dir('project') {
                    sh 'chmod +x ./mvnw'
                    sh """
                        ./mvnw clean verify sonar:sonar \
                        -Dsonar.host.url=${params.SONAR_URL} \
                        -Dsonar.login=${params.SONAR_TOKEN} \
                        -DskipTests
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('project') {
                    script {
                        docker.withRegistry('https://index.docker.io/v1/', "${params.DOCKER_CREDENTIALS}") {
                            def app = docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                            app.push()
                        }
                    }
                }
            }
        }

        stage('Actualizar Docker Compose') {
            steps {
                script {
                    sh "cd ${DOCKER_COMPOSE_PATH} && APP_ENV=${params.ENVIRONMENT} docker compose pull ${SERVICE_NAME}"
                    sh "cd ${DOCKER_COMPOSE_PATH} && APP_ENV=${params.ENVIRONMENT} docker compose up -d ${SERVICE_NAME}"
                }
            }
        }
    }

    post {
        success {
            echo "El pipeline se ejecutó exitosamente."
        }
        failure {
            echo "El pipeline falló. Revisa los logs para más detalles."
        }
    }
}
