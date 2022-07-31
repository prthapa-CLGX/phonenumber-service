node {
    try {
        def serviceName = ""
        stage('SCM Checkout') {
            checkout scm
            checkout([$class: 'GitSCM',
               branches: [[name: env.BRANCH_NAME]],
               extensions: [[$class: 'CleanBeforeCheckout']],
               userRemoteConfigs: [[url: 'https://github.com/prthapa-CLGX/phonenumber-service.git']]
           ])
        }

        stage('Gradle build') {
           sh('./gradlew -i clean build')
        }

        stage('BuildImage PushToLocalRegistry') {
           sh('./gradlew -i dockerPush')
        }

        stage('CT: Master Test') {
            def version = sh(script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'", returnStdout: true).trim()
            serviceName = sh(script: "./gradlew properties -q | grep \"archivesBaseName:\" | awk '{print \$2}'", returnStdout: true).trim()
            sh "echo Service: $serviceName Version: $version"
            // remove the images on this node. The next job should pull the image from the local registry
            sh("docker images | grep localhost:5000/$serviceName | tr -s ' ' | cut -d ' ' -f 2 | xargs -I {} docker rmi localhost:5000/$serviceName:{}")
            build job: 'poc-master-test', propagate: true, wait: true
        }
    } catch(e) {
        throw (e)
    } finally {
        stage('Clean Up and Notify') {
           sh('echo cleaning up tasks......')
           sh('echo "If Build Fail: Sending email ............."')
           //mail to: "me@testemail.com"
        }
    }
}
