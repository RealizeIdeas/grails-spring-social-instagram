grails-spring-social-instagram
==============================

Grails plugin to use Instagram via Spring Social API

Required properties in Config.groovy<br/>

instagram.clientId = "<client_id>"<br/>
instagram.clientSecret = "<client_secret>"<br/><br/>

After this properties are configured you can use 'instagram' providerId in your app with spring social core to connect
 user Instagram account. After this all operations you got permissions for are available through InstagramTemplate.
<br/>
  Example of add Instagram account button:<br/>
  <g:form method="POST" mapping="springSocialConnect" params="[providerId: 'instagram']"><br/>
    <g:hiddenField name="scope" value="basic comments relationships likes""/><br/>

    <button type="submit" >Connect Instagram</button><br/>
  </g:form><br/>

