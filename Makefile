say_hello:
	@echo "heloo world"

clean:
	./gradlew clean

test:
	./gradlew test

build:
	,/gradlew build

pre_commit: clean test build