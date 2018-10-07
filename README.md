# OAuth-Resource-Server

<h3>Authorization Server</h3>
<b>1.</b>This server generate JWT tokens for clients to access Resource server.</br>
<b>2.</b>Execute AuthorizationServer-0.0.1-SNAPSHOT.jar file inside the AuthorizationServer\build\libs\ Directory</br>
<b>3.</b>Use this command in cmd to run AuthorizationServer-0.0.1-SNAPSHOT.jar file --> java -jar AuthorizationServer-0.0.1-SNAPSHOT.jar</br>
This will start the Authorization Server.</br>
<b>4.</b>The server should now be running at http://localhost:8080.

-->> Read the blog post to learn step by step process of building Resource Server.</br>
https://authserver.blogspot.com/2018/10/building-authorization-server.html

</br>
<h3>Resource Server</h3>
<b>1.</b>This server reponse with a success message for the request it receives with a valid token.</br>
<b>2.</b>Execute ResourceServer-0.0.1-SNAPSHOT.jar file inside the ResourceServer\build\libs\ Directory</br>
<b>3.</b>Issue this command in cmd to run ResourceServer-0.0.1-SNAPSHOT.jar file --> java -jar ResourceServer-0.0.1-SNAPSHOT.jar</br>
This will start the Resource Server.</br>
<b>4.</b>The server should now be running at http://localhost:8081.

-->> Read the blog post to learn step by step process of building Resource Server.</br>
https://authserver.blogspot.com/2018/10/building-resource-server.html
 
