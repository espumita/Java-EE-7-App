FROM glassfish/server:4.1.1

ADD ./servlet/target/servlet-1.0.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy
ADD ./ejbs/target/ejbs-1.0.jar $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy