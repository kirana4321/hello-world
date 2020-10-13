def gv
pipeline{
    agent any
    parameters{
        choice(name: 'VERSION', choices:['1.1.0','1.2.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    stages {
        stage("init"){
            steps{
                script{
                    gv=load "script.groovy"
                }
            }

        }
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
                echo 'Print Building a new app'
                echo "building the version ${NEW_VERSION}"
            }
        }
        stage("test"){
            when {
                expression{
                    BRANCH_NAME =='master'
                    params.executeTests
                }
            }
            steps{
                script{
                    gv.testApp()
                }
                echo 'Print TEsting a new app'
            }
        }
        stage("deploy only"){
            steps{
                script{
                    gv.deployApp()
                }
                echo 'Print Deploying a new app'
                echo "deploying version ${params.VERSION}"
                echo 'FYI, we should use params.Version'
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
