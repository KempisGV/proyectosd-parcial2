proyectosd-parcial2
#Instrucciones para instalar RabbitMQ en Ubuntu 
1. En el cmd se ingresann los siguientes comandos para actualizar el sistema: sudo apt-get update ,  sudo apt-get upgrade.
2. Para instalar Erlang se necesita importar el repositorio de Erlang con el comando `wget -O- https://packages.erlang-solutions.com/ubuntu/erlang_solutions.asc | sudo apt-key add -`. Luego se añade Erlang a ubuntu con el comando `echo "deb https://packages.erlang-solutions.com/ubuntu focal contrib" | sudo tee /etc/apt/sources.list.d/rabbitmq.list`. Finalmente utilizamos `sudo apt install erlang` para instlar Erlang.
3. Para verificar que se instaló correctamente Erlang utilice el comando `erl`
4. Luego de instalar Erlang procedemos a colocar el siguiente comando `echo "deb https://dl.bintray.com/rabbitmq/debian xenial main" | sudo tee /etc/apt/sources.list.d/bintray.rabbitmq.list`
5. Añadimos la public key a nuestra lista de keys confiables con el comando `wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -`
6. Antes de terminar de instalar RabbitMQ necesitamos actualizar la lista de paquetes con el comando `sudo apt-get update`. Finalmente utilizamos `sudo apt-get install rabbitmq-server`
7. Para iniciar el servidor de RabbitMQ colocamos en el cmd  `sudo systemctl start rabbitmq-server.service`  y `sudo systemctl enable rabbitmq-server.service`
8. Finalmente chequeamos el estado del servidor con el comando `sudo rabbitmqctl status`


#Instrucciones para compilar y ejecutar la aplicación en Ubuntu 
1. 
2. 






Referencias 
* https://www.vultr.com/docs/how-to-install-rabbitmq-on-ubuntu-16-04-47
* https://computingforgeeks.com/how-to-install-latest-erlang-on-ubuntu-linux/
