#! groovy

buildDirHelloModule = "build_hello_module"
buildDirMavenHelloModule = "build_maven_hello_module"

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout projects from git") {
            steps {
                echo "Checkout project from git to folder ${buildDirHelloModule}:"
                dir("${buildDirHelloModule}") {
                    checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                              doGenerateSubmoduleConfigurations: false, extensions: [],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/hello-world-project-for-docker.git']]])
                }

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
                echo "Creating threads dump..."
                sh label: '', script: 'ps -el | grep java'
            }
        }
        stage("Solving problems with threads") {
            steps {
                echo "Solving problems with threads"
            }
        }
    }


}