# Sample-OAuth-Resource-Server
 Demonstrate the role of OAuth resource server 
<h1>Guidelines</h1>
<h3>Authorization Server</h3>
<b>1.</b>This server generate JWT tokens for clients to access Resource server.</br>
<b>2.</b>Execute AuthorizationServer-0.0.1-SNAPSHOT.jar file inside the AuthorizationServer\build\libs\ Directory</br>
<b>3.</b>Issue this command in cmd to run AuthorizationServer-0.0.1-SNAPSHOT.jar file --> java -jar AuthorizationServer-0.0.1-SNAPSHOT.jar</br>
This will start the Authorization Server.</br>
<b>4.</b>The server should now be running at http://localhost:8080.
</br>
<h3>Resource Server</h3>
<b>1.</b>This server reponse with a success message for the request it receives with a valid token.</br>
<b>2.</b>Execute ResourceServer-0.0.1-SNAPSHOT.jar file inside the ResourceServer\build\libs\ Directory</br>
<b>3.</b>Issue this command in cmd to run ResourceServer-0.0.1-SNAPSHOT.jar file --> java -jar ResourceServer-0.0.1-SNAPSHOT.jar</br>
This will start the Resource Server.</br>
<b>4.</b>The server should now be running at http://localhost:8081.

-->> visit this blog post to get breif description about how this project create and how to run this servers.</br>
https://digitalfortresslk.wordpress.com/2018/05/27/sample-oauth-resource-server/
 
