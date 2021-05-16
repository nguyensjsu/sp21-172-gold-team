all: clean

clean:
	gradle clean

compile:
	gradle build

test:
	gradle test

jar: 
	gradle build -x test
	gradle bootJar

run: jar
	echo Starting Spring at:  http://localhost:8080
	java -jar build/libs/spring-gumball-2.0.jar

# Docker

docker-build: jar
	docker build -t starbucks-gold .
	docker images

docker-run: docker-build
	docker run --name starbucks-gold -td -p 80:8080 starbucks-gold	
	docker ps

docker-clean:
	docker stop starbucks-gold
	docker rm starbucks-gold
	docker rmi starbucks-gold

docker-shell:
	docker exec -it starbucks-gold bash 

docker-push:
	docker login
	docker build -t $(account)/starbucks-gold:v1 -t $(account)/starbucks-gold:v1 .
	docker push $(account)/starbucks-gold:v1 

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge starbucks-gold-v1_network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale gold=1 -d

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-gumball

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it starbucks-gold -- /bin/bash

pod-logs:
	kubectl logs -f starbucks-gold

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=starbucks-gold

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment starbucks-gold-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service starbucks-gold -o wide

service-delete:
	kubectl delete service starbucks-gold

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress starbucks-gold-ingress




