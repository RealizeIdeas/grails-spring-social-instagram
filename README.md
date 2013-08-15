Grails Spring Social plugin for Instagram
==============================

Grails plugin to use Instagram via Spring Social API

### Required properties in Config.groovy:

instagram.clientId = "client_id"

instagram.clientSecret = "client_secret"

After this properties are configured you can use 'instagram' providerId in your app with spring social core to connect user Instagram account. After this all operations you got permissions for are available through InstagramTemplate.

### Examples
## Add Instagram account button:
```html
  <g:form method="POST" mapping="springSocialConnect" params="[providerId: 'instagram']">
    <g:hiddenField name="scope" value="basic comments relationships likes"/>
    <g:submitButton name="connectInstagram" value="Connect Instagram"/>
  </g:form>
```

## Get Media files from Instagram account:
```groovy
InstagramTemplate instagramTemplate = new InstagramTemplate(grailsApplication.config.instagram.clientId, userConnection.accessToken)
PagedMediaList result = instagramTemplate.userOperations().getRecentMedia(instagramConnection.providerUserId as Long)
```

