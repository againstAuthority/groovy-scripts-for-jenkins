#! groovy

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout") {
            steps {
                echo "Checkout..."
            }
        }
        stage("Deploy") {
            steps {
                echo "Deploying..."
            }

        }
        stage("Undeploying modules") {

            steps {
                echo "Undeploying modules..."
            }
        }
        stage("Creating threads dump") {
            steps {
                echo "Creating threads dump"
            }
        }
        stage("Solving problems with threads") {
            steps {
                echo "Solving problems with threads"
            }
        }
    }
}