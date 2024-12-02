# 说明
boot 项目是入口项目，可以用来打包和运行

demo 项目是用来写业务代码的地方，fork本项目后，应该把demo字样改成实际业务

注意 demo 项目里提供了单元测试的例子，需要同步改动，不然影响项目测试和打包

数据库启动（docker）：
`docker run --rm  -p 54324:5432 -e POSTGRES_PASSWORD=muyun2024 -e POSTGRES_DB=muyun  postgres:17-alpine`

项目启动（首次启动会引导你设置管理员账号密码）：
`./gradlew --console=plain :boot:quarkusDev`

项目打包：
` ./gradlew :boot:build -Dquarkus.package.jar.type=uber-jar`

项目打包（跳过单元测试）：
` ./gradlew :boot:build -Dquarkus.package.jar.type=uber-jar -x test`

运行jar包：
`java -jar boot/build/boot-1.0-SNAPSHOT-runner.jar`
