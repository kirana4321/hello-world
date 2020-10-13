def buildApp(){
    echo "Groovy script to Build an application"
}

def testApp(){
    echo "Groovy script to Test an application"
}


def deployApp(){
    echo "Groovy script to deploy an application version ${params.VERSION}"
}

return this
