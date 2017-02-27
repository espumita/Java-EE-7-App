FROM glassfish/server:4.1.1

ADD ./servlets/servlet/target/MyApp.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy