repositories.remote << "http://repo1.maven.org/maven2/"

define "simple-hello-world" do
  project.version = "0.1.0"
  package :jar

  compile.with transitive("org.simpleframework:simple:jar:4.1.21")
  run.using :main => "org.sam.HelloWorld"
end