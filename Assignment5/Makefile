# Rahul Deeljore
# Assignment3
# April 2018

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin


$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= A.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)


clean:
	rm $(BINDIR)/*.class
run:

	java -cp bin /usr/share/java/mysql-connector-java.jar:. A

