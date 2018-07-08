./mvnw package
docker build . -t 207.154.237.15:5000/vetal-iot
docker push 207.154.237.15:5000/vetal-iot