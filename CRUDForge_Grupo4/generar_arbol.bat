@echo off
echo Generando parser de ANTLR y mostrando arbol...
java -jar C:\antlr\antlr-4.13.2-complete.jar CRUDForge.g4
javac -cp ".;C:\antlr\antlr-4.13.2-complete.jar" *.java
type input\producto.crudf | java -cp ".;C:\antlr\antlr-4.13.2-complete.jar" org.antlr.v4.gui.TestRig CRUDForge start -gui
pause
