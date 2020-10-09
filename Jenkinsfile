pipeline{
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {
        stage("build"){
            steps{
                echo 'Print Building a new app'
                echo "building the version ${NEW_VERSION}"
            }
        }
        stage("test"){
            when {
                expression{
                    BRANCH_NAME =='master'
                }
            }
            steps{
                echo 'Print TEsting a new app'
            }
        }
        stage("deploy only"){
            steps{
                echo 'Print Deploying a new app'
                withCredentials([
                    usernamePassword(credentials: 'SERVER_CREDENTIALS', usernameVariable: USER, passwordVariable: PWD)
                ]){
                    sh "some script ${USER} ${PWD}"
                }
            }
        }
    }
    post{
        success{
            echo 'Build is success now'
        }
        failure{
            echo 'build got failed'
        }
    }
}

node {
  //grovvy script
}
