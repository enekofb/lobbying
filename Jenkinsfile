node {
    def mvnHome
    stage('Preparation') { // for display purposes
        mvnHome = tool 'M3'
    }

    stage('Checkout code') {
        git 'https://github.com/enekofb/lobbying.git'

    }
    stage('Build a Maven project') {
        dir("policy") {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
        }

    }

}