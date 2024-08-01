FROM eclipse-temurin:21-jdk-jammy AS deps

WORKDIR /build

COPY --chmod=0755 gradlew gradlew
COPY gradle/ gradle/
COPY build.gradle.kts settings.gradle.kts ./

FROM deps AS package

WORKDIR /build

COPY . .
RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew --no-daemon assemble && \
    mv build/libs/*SNAPSHOT.jar app.jar


FROM eclipse-temurin:21-jre-jammy AS final

ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

COPY --from=package build/app.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]