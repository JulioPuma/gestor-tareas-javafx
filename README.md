# gestor-tareas-javafx

Proyecto usando JavaFX para un control sencillo de gestion de tareas (CRUD).

comando jpackage

``
jpackage \
--input target/ \
--name GestorTareas \
--main-jar gestor-tareas-javafx-1.0-SNAPSHOT.jar \
--main-class com.gestor.gestortareasjavafx.TareaApplication \
--type exe \
--icon src/main/resources/images/icon.ico \
--app-version 1.0.0 \
--runtime-image custom-runtime
--output instaladores/
``

``
jpackage --input target/ --name GestorTareas --main-jar gestor-tareas-javafx-1.0-SNAPSHOT.jar --main-class com.gestor.gestortareasjavafx.TareaApplication --type exe --icon src/main/resources/images/icon.ico --app-version 1.0.0 --win-console
``