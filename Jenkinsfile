node {
	def app
	def image = 'registry.hub.docker.com/avadhootdhere/assesement-comprehensive'
	def branch = 'master'
	
	try {
		stage('Clone repository') {               
	    	git branch: branch,
	        	credentialsId: 'GitHub Credentials',
	        	url: 'https://github.com/AvadhootDhere/ComprehensiveAssesement.git'
	    } 
	
		stage('Build JAR') {
	    	docker.image('maven:3.6.3-jdk-1.8').inside('-v /root/.m2:/root/.m2') {
	        	sh 'mvn -B clean package'
	        	stash includes: '**/target/assesement-comprehensive.jar', name: 'jar'
	    	}
	    }
	     
	    stage('Build Image') {
	    	unstash 'jar'
			app = docker.build image + ':$BUILD_NUMBER'
	    }
	    
	    stage('Push') {
	    	docker.withRegistry('https://registry.hub.docker.com', 'DockerHubId') {            
				app.push()
	        }    
	    }
	} catch (e) {
		echo 'Error occurred during build process!'
		echo e.toString()
		currentBuild.result = 'FAILURE'
	} finally {
        junit '**/target/surefire-reports/TEST-*.xml'		
	}
}
