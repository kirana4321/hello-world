pipeline{
    agent any
    stages {
        stage("build"){
            steps{
                echo 'Print Building a new app'
            }
        }
        stage("test"){
            steps{
                echo 'Print TEsting a new app'
            }
        }
        stage("deploy only"){
            steps{
                echo 'Print Deploying a new app'
            }
        }
    }
    post{
        always {
            //
        }
        success{
            echo 'Build success'
        }
        failure{
            echo 'build failed'
        }
    }
}

node {
  //grovvy script
}
