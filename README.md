This is JMeter plugin for Gradle build system. This plugin
enables running JMeter test using Gradle.

USAGE
=====
1) Create a build.gradle file in the root directory of the project, and
include the JMeter plugin as follows:

apply plugin: 'jmeter'

    buildscript {
        repositories {
            maven {
                url "http://repo.kulya.info/content/groups/public/"
            }
        }
        dependencies {
            classpath "org.veil.gradle.plugins:jmeter-gradle-plugin:1.2-2.6-SNAPSHOT"
        }
    }

2) Tune JMeter plugin to match your sources directory i.e.:

    jmeterRun.configure {
        jmeterTestFiles = [file("src/test/jmeter/test1.jmx"), file("src/test/jmeter/test2.jmx"), file("src/test/jmeter/test3.jmx")]
    }

3) With this plugin you can specify next JMeter properties:
* srcDir - Directory with JMeter test files if you want include them all without strict order [ $project.dir/src/test/jmeter by default ]
* includes - JMeter files that you want to include at build
* excludes - JMeter files that you want to exclude from build
* jmeterTestFiles - List of JMeter test files (overrides srcDir)
* reportDir - Directory where you want to store your reports [ $project.buildDir/jmeter-report by default ]
* enableReports - Enable/Disable report generation [ true by default ]
* jmeterIgnoreFailure - Ignore JMeter failures  [ false by default ]
* jmeterIgnoreError - Ignore JMeter errors [ false by default ]
* reportPostfix - Postfix that you want to use at report file  [ "-report.html" by default ]
* reportXslt - Report XSLT location, if you want to use custom transformation
* jmeterUserProperties - List of JMeter user properties

4) To run JMeter test execute
    
    gradle jmeter

At project directory