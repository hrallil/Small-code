/*
   BasicHTTPSClient.in
    Created on: 14.10.2018
*/

#include <Arduino.h>
#include <WiFi.h>
#include <WiFiMulti.h>
#include <HTTPClient.h>

#define ONBOARD_LED  2

WiFiMulti WiFiMulti;

void setup() {
  Serial.begin(9600);
  // Serial.setDebugOutput(true);
  Serial.println();
  Serial.println();
  Serial.println();
  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP("HelloThere", "asdf1234");

  // wait for WiFi connection
  Serial.print("Waiting for WiFi to connect...");
  while ((WiFiMulti.run() != WL_CONNECTED)) {
    Serial.print(".");
  }
  Serial.println(" connected");
  pinMode(ONBOARD_LED,OUTPUT);
}

void loop() {
  WiFiClient *client = new WiFiClient;
  if (client) {
    {
      // Add a scoping block for HTTPClient https to make sure it is destroyed before WiFiClientSecure *client is
      HTTPClient http;
      Serial.print("[HTTPS] begin...\n");
      if (http.begin(*client, "http://api.openweathermap.org/data/2.5/weather?q=roskilde,dk&APPID=d28e0b6cfa6d48a373d2359ff966fbad&units=metric")) {  // HTTPS
        Serial.print("[HTTPS] GET...\n");
        // start connection and send HTTP header
        int httpCode = http.GET();
        // httpCode will be negative on error
        if (httpCode > 0) {
          // HTTP header has been send and Server response header has been handled
          Serial.printf("[HTTPS] GET... code: %d\n", httpCode);
          // file found at server
          if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_MOVED_PERMANENTLY) {
            String payload = http.getString();
            Serial.println("### The full json ###");
            Serial.println(payload);
            // WARNING: This is a hack to get the temp - you should use arduinojson library (https://arduinojson.org/)
            int startTempPos = payload.indexOf("\"temp\":") + 7; // +7 to compensate for the lenght
            int endTempPos = payload.indexOf(",\"feels_like\"");
            float currentTemp  = payload.substring(startTempPos, endTempPos).toFloat();
            Serial.print("The temp is:");
            Serial.println(currentTemp);

            if(currentTemp > 4){
              digitalWrite(ONBOARD_LED, HIGH);
            }else{
              digitalWrite(ONBOARD_LED, LOW);
            }
          }
        } else {
          Serial.printf("[HTTPS] GET... failed, error: %s\n", http.errorToString(httpCode).c_str());
        }
        http.end();
      } else {
        Serial.printf("[HTTPS] Unable to connect\n");
      }
      // End extra scoping block
    }
    delete client;
  } else {
    Serial.println("Unable to create client");
  }
  Serial.println();
  Serial.println("Waiting 10s before the next round...");
  delay(10000);
}
