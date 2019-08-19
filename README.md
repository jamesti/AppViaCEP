# App ViaCEP
App que consulta Endereços através da API do [ViaCep](https://viacep.com.br/).

## Como usar

Não esqueça de colocar a permissão de Internet no arquivo AndroidManifest.

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

O aplicativo usa o Volley API como dependência.

```gradle
dependencies {
    ...
    implementation 'com.android.volley:volley:1.1.1'
}
```
