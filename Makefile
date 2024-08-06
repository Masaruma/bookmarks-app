clean:
	./gradlew clean

test:
	./gradlew test

package:
	./gradlew assemble

lint:
	./gradlew spotlessApply

pre-commit: clean lint test package