# HelloWorld program makefile
# Hussein Suleman
# 26 February 2018

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class BinaryTree.class BTQueueNode.class BTQueue.class BinarySearchTree.class Dam.class DamArrayApp.class DamBSTApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
run:
	java -cp bin DamArrayApp
run2: 
	java -cp bin DamArrayApp String a
run3:
	java -cp bin DamBSTApp
run4:
	java -cp bin DamBSTApp string b
