pipeline {
    agent any

    parameters {
        credentials(name: 'DOCKER_CREDENTIALS', description: 'Docker Hub credentials')
        string(name: 'SONAR_URL', description: 'Sonar URL', defaultValue: 'http://sonarqube:9000')
        string(name: 'SONAR_TOKEN', description: 'Sonar token')
        string(name: 'ENVIRONMENT', description: 'Environment', defaultValue: 'dev')
    }

    environment {
        SERVICE_NAME = 'scheduler-msvc'
        IMAGE_NAME = 'yurigrow/viand-scheduler-msvc'
        IMAGE_TAG = "0.0.${env.BUILD_NUMBER}"
        DOCKER_COMPOSE_PATH = '/mnt/msvc'
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

        // Durante la etapa de analisis con SonarQube se compilara la aplicacion para crear el JAR
        // que sera usado para construir la imagen docker
        stage('Análisis con SonarQube') {
            steps {
                sh 'chmod +x ./mvnw'
                sh """
                    ./mvnw clean verify sonar:sonar \
                    -Dsonar.host.url=${params.SONAR_URL} \
                    -Dsonar.login=${params.SONAR_TOKEN} \
                    -DskipTests
                """
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${params.DOCKER_CREDENTIALS}") {
                        def app = docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                        app.push()
                        // Actualizamos la etiqueta 'latest' para que apunte a esta versión
                        app.push('latest')
                    }
                }
            }
        }

        stage('Actualizar Docker Compose') {
            steps {
                script {
                    sh """
                        cd ${DOCKER_COMPOSE_PATH}
                        APP_ENV=${params.ENVIRONMENT} docker compose pull ${SERVICE_NAME}
                        APP_ENV=${params.ENVIRONMENT} docker compose up -d ${SERVICE_NAME}
                    """
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
