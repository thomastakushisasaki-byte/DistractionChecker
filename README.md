# 🚫 集中力ブレイカー・チェッカー (Distraction Checker)


「何が自分の集中を邪魔したか」を記録し、生産性低下の原因を分析するためのフルスタックWebアプリケーションです。

単なるToDo管理ではなく、**「何に時間を奪われたか」**という負のデータを可視化することで、問題解決への意識を高めることを目的としています。


## 🛠 技術スタック

本プロジェクトは、モダンなJava開発環境と、エンタープライズで標準的なデータベース技術を組み合わせて構築しています。

### Backend
-   **Java 17 (または21)**
-   **Spring Boot 3.2.x**
    -   Spring Data JPA
    -   Spring Web
-   **Lombok**

### Database
-   **Oracle Database 23c Free Edition** (Dockerコンテナにて構築)
-   **H2 Database** (開発・テスト用)

### Frontend
-   **Thymeleaf** (Java標準テンプレートエンジン)
-   **Bootstrap 5** (CSSフレームワーク)

### DevOps / Infrastructure
-   **Docker / Docker Desktop** (Oracle環境のコンテナ化)
-   **GitHub** (ソースコード管理・バージョン管理)

## ✨ 実現した機能

1.  **リアルタイム記録機能**: 邪魔された原因、カテゴリ、失った時間を画面から登録。
2.  **永続化機能 (Oracle DB)**: 登録したデータをOracle Databaseに保存。
3.  **履歴表示機能**: 保存されたデータを、発生日時順に一覧表示。
4.  **自動データベース構築**: Spring Data JPAによるEntityからのテーブル自動生成 (ddl-auto: update)。

## 💡 こだわった点・学んだ点

### 1. エンタープライズ環境の実践
単なる軽量DBではなく、実務での採用実績が多い **Oracle Database** を採用しました。Java×Oracleの組み合わせを実践することで、堅牢なシステム構築の基礎を学びました。

### 2. インフラのコード化 (IaC) とDocker活用
Oracle環境をPCに直接インストールするのではなく、**Docker** コンテナとして構築しました。これにより、環境の構築・破棄をコードベースで管理でき、他の開発者と同じ環境を爆速で用意できるモダンな開発スタイルを実践しました。

### 3. オブジェクト指向とレイヤードアーキテクチャ
Spring Bootのレールの乗っとり、`Entity`, `Repository`, `Controller` という役割分担（レイヤードアーキテクチャ）を意識しました。インターフェースを活用することで、DB操作を抽象化し、コードの可読性と保守性を高めています。

### 4. Gitによるバージョン管理
`branch`の管理や、適切な`commit`メッセージを意識し、GitHubへのプッシュまでを一貫して行いました。

## 🚀 起動方法

### 前提条件
-   Docker Desktopがインストールされていること。

### 手順

1.  **Oracleコンテナの起動**
    ```bash
    docker run -d --name oracle-distraction -p 1522:1521 -e ORACLE_PASSWORD=pass gvenzl/oracle-free
    ```

2.  **アプリケーションのビルドと起動 (Maven)**
    IntelliJ等のIDEで `DemoApplication.java` を実行、またはターミナルで以下を実行します。
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **アクセス**
    ブラウザで `http://localhost:8080/` にアクセスしてください。
