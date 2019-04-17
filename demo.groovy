#! groovy

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout") {
            steps {
                echo "Checkout..."
                checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                          doGenerateSubmoduleConfigurations: false, extensions: [],
                          submoduleCfg                     : [],
                          userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/hello-world-project-for-docker.git']]])
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