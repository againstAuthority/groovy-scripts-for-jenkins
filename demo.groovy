#! groovy

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout") {
            echo "Checkout"
        }
        stage("Deploy") {
            echo "Deploying"
        }
        stage("Undeploying modules") {
            echo "Undeploying"
        }
        stage("Creating threads dump") {
            echo "Creating threads dump"
        }
        stage("Solving problems with threads") {
            echo "Solving problems with threads"
        }
    }
}