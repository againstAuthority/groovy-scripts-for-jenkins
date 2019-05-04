#! groovy

helloModulebuildDir = "build_hello_module"
ansiblebuildDir = "ansiblebuildDir"

pipeline {
    agent {
        label 'master'
    }

    stages {
        stage("Checkout hello-module project from git") {
            steps {
                echo "Checkout project from git to folder ${helloModulebuildDir}:"
                dir("${helloModulebuildDir}") {
                    checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                              doGenerateSubmoduleConfigurations: false, extensions: [],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/hello-world-project-for-docker.git']]])
                }
            }
        }
        stage("Checkout ansible project from git") {
            steps{
                echo "Checkout ansible project from git to folder ${ansiblebuildDir}:"
                dir("${ansiblebuildDir}") {
                    checkout([$class                           : 'GitSCM', branches: [[name: '*/master']],
                              doGenerateSubmoduleConfigurations: false, extensions: [],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[url: 'https://github.com/againstAuthority/ansible.git']]])
                }
            }
        }
        stage("Deploy") {
            steps {
                echo "Deploying..."
//
                ansiblePlaybook colorized: true, credentialsId: 'af9c6101-8e32-4298-a090-27b434894dca',
                        disableHostKeyChecking: true, inventory: 'ansiblebuildDir/inventories/', playbook: 'ansiblebuildDir/demo.yml'
            }

        }
    }
}