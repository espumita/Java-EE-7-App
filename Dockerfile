FROM glassfish/server:4.1.1

WORKDIR /glassfish4/glassfish/modules
RUN rm jboss-logging.jar
RUN wget http://repo1.maven.org/maven2/org/jboss/logging/jboss-logging/3.3.0.Final/jboss-logging-3.3.0.Final.jar

WORKDIR /

ADD ./servlets/target/servlet-1.0.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy
ADD ./ejbs/target/ejbs-1.0.jar $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy