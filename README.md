# 说明
boot 项目是入口项目，可以用来打包和运行

demo 项目是用来写业务代码的地方，fork本项目后，应该把demo字样改成实际业务

注意 demo 项目里提供了单元测试的例子，需要同步改动，不然影响项目测试和打包

项目启动：
`./gradlew :boot:quarkusDev`

项目打包：
` ./gradlew :boot:build -Dquarkus.package.jar.type=uber-jar`

运行jar包：
`java -jar boot/build/boot-1.0-SNAPSHOT-runner.jar`
