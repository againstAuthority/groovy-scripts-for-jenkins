#! groovy

pipeline{
    agent{
        label 'master'
    }

    stages{
        stage("Stage1"){
            steps{
                echo "Stage1"
            }
        }
    }
}