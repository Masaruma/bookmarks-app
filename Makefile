clean:
	./gradlew clean

test:
	./gradlew test

build:
	,/gradlew build

lint:
	./gradlew spotlessApply

pre_commit: clean lint test build