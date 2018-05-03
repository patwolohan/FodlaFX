@ECHO	OFF
REM	---------------------------------------------------------------------
REM	expects	the	MAVEN	and	JAVA	environment	variables	to	be	setup
REM	---------------------------------------------------------------------
REM	Maven	clean	and	build	JAR
mvn	clean package

PAUSE