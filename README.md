# proyectosd-parcial2
# Integrantes:
* Kempis Guerrero
* Mathias Loor
* David Torres
# Instrucciones para instalar RabbitMQ en Ubuntu 
1. En el cmd se ingresann los siguientes comandos para actualizar el sistema: `sudo apt-get update` ,  `sudo apt-get upgrade`.
2. Para instalar Erlang se necesita importar el repositorio de Erlang con el comando `wget -O- https://packages.erlang-solutions.com/ubuntu/erlang_solutions.asc | sudo apt-key add -`. Luego se añade Erlang a ubuntu con el comando `echo "deb https://packages.erlang-solutions.com/ubuntu focal contrib" | sudo tee /etc/apt/sources.list.d/rabbitmq.list`. Finalmente utilizamos `sudo apt install erlang` para instlar Erlang.
3. Para verificar que se instaló correctamente Erlang utilice el comando `erl`
4. Luego de instalar Erlang procedemos a colocar el siguiente comando `echo deb https://dl.bintray.com/rabbitmq/debian xenial main | sudo tee /etc/apt/sources.list.d/bintray.rabbitmq.list`
5. Añadimos la public key a nuestra lista de keys confiables con el comando `wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -`
6. Antes de terminar de instalar RabbitMQ necesitamos actualizar la lista de paquetes con el comando `sudo apt-get update`. Finalmente utilizamos `sudo apt-get install rabbitmq-server`
7. Para iniciar el servidor de RabbitMQ colocamos en el cmd  `sudo systemctl start rabbitmq-server.service`  y `sudo systemctl enable rabbitmq-server.service`
8. Finalmente chequeamos el estado del servidor con el comando `sudo rabbitmqctl status`


# Instrucciones para compilar y ejecutar la aplicación en Ubuntu  
1. Ejecutar el comando `sudo ifconfig enp0s8 10.10.10.X`(x es el numero del nodo) para configurar la red interna de la máquina virtual, la máquina que haráel reportero deberá tener la ip 10.10.10.1 y la máquina que hará de productor y consumidor 10.10.10.2
2. Instalar el jdk de java utilizando el comando `sudo apt install default-jdk`.
3. Asegurarse de tener correctamente instalado RabbitMQ.
4. Para comprobar que java está instalado ejecutar el comando `javac`.
5. Una vez ubicados en la carpeta del proyecto en la máquina virtual que hará de productor y consumidor nos movemos a la carpeta src y se necesita agregar al classpath las siguientes librerias: amqp-client-5.7.1.jar, slf4j-api-1.7.26.jar, slf4j-simple-1.7.26.jar para esto se utilizará los siguientes comandos: `export CLASSPATH=amqp-client-5.7.1.jar:$CLASSPATH`, `export CLASSPATH=slf4j-api-1.7.26.jar:$CLASSPATH`, `export CLASSPATH=slf4j-simple-1.7.26.jar:$CLASSPATH`
6. Luego procedemos a compilar en ambas maquinas los modulos correspondientes para ello ejecutamos el comando `javac *.java`y `javac Reportero.java`, luego de verificar que se compilo correctamente ejecutamos el comando `java Productor`,  `java Consumidor` Y `java Reportero`.





Referencias 
* https://www.vultr.com/docs/how-to-install-rabbitmq-on-ubuntu-16-04-47
* https://computingforgeeks.com/how-to-install-latest-erlang-on-ubuntu-linux/
