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
                ansiblePlaybook become: true, becomeUser: 'dmitry', inventory: 'ansiblebuildDir/demo.yml', playbook: 'ansiblebuildDir/inventories/'
            }

        }
    }
}