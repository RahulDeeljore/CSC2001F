# Rahul Deeljore
# Assignment3
# April 2018

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
JAVADOC=javadoc

SRCDIR=src
BINDIR=bin
DOCDIR=docs

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=person.class HashTable.class RandomNumber.class VerifyVoter.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

doc:
	$(JAVADOC) -sourcepath $(SRCDIR)/HashTable.java $(SRCDIR)/person.java $(SRCDIR)/RandomNumber.java $(SRCDIR)/VerifyVoter.java -d $(DOCDIR)

clean:
	rm $(BINDIR)/*.class
run:
	java -cp bin VerifyVoter

