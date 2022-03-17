#define RIGHT_LED  19
#define LEFT_LED  22
#define VAR_Y_IN 14
#define VAR_X_IN 27
#define BTTN 26

void setup() {
  pinMode(BTTN, INPUT_PULLUP); //SW
  pinMode(VAR_Y_IN, INPUT_PULLUP); //varY
  pinMode(VAR_X_IN, INPUT_PULLUP); //varx
  pinMode(RIGHT_LED, OUTPUT);             // right lamp
  pinMode(LEFT_LED, OUTPUT);             // left lamp
  Serial.begin(9600);
}

void loop() {
  if (digitalRead(BTTN) == false) {
    Serial.println("sw");
  }
  Serial.print("var X: ");
  Serial.print(analogRead(VAR_X_IN));
  Serial.print("var Y: ");
  Serial.println(analogRead(VAR_Y_IN));

  
  /*
  if(analogRead(VAR_X_IN)> 3500){
    Serial.print("var X: ");
    Serial.println(analogRead(27));
    digitalWrite(RIGHT_LED, HIGH);
  }else if(analogRead(VAR_X_IN)< 1000){
    Serial.print("var X: ");
    Serial.println(analogRead(VAR_X_IN));
    digitalWrite(LEFT_LED, HIGH);
  }else{
    digitalWrite(LEFT_LED, LOW);
    digitalWrite(RIGHT_LED, LOW);
  }

  */
  
}
