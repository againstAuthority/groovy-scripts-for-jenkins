#! groovy

helloModulebuildDir = "build_hello_module"
ansiblebuildDir = "ansiblebuildDir"

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout hello-module project from git") {
                echo "Checkout project from git to folder ${helloModulebuildDir}:"
                dir("${helloModulebuildDir}") {
                    checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                              doGenerateSubmoduleConfigurations: false, extensions: [],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/hello-world-project-for-docker.git']]])
                }
        }
        stage("Checkout ansible project from git") {
            echo "Checkout ansible project from git to folder ${ansiblebuildDir}:"
            dir("${ansiblebuildDir}") {
                checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                          doGenerateSubmoduleConfigurations: false, extensions: [],
                          submoduleCfg                     : [],
                          userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/ansible.git']]])
            }
        }
        stage("Install hello-module project with maven") {
            steps {
                echo "Installing hello-module project with maven..."
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