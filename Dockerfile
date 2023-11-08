# Dockerfile
#FROM openjdk:17
#COPY target/api_sample_eager-0.0.1-SNAPSHOT.jar /app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]


# 特定のJDKバージョンをベースイメージとして使用
FROM openjdk:17

# Mavenをインストール
#RUN apt-get update && apt-get install -y maven
#RUN apk update && apk add --no-cache maven

# 作業ディレクトリを設定
WORKDIR /app

# アプリケーションのJARファイルをコンテナにコピー
COPY . /app

# Mavenを実行してアプリケーションをビルド
#RUN mvn clean install

# アプリケーションを実行
ENTRYPOINT ["java", "-jar", "/app/target/api_sample_eager-0.0.1-SNAPSHOT.jar"]