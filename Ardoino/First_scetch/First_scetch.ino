#define ONBOARD_LED  2
boolean isPressedDown = false;
int pressedFor;

void setup() {
  pinMode(ONBOARD_LED, OUTPUT);
  pinMode(18, INPUT_PULLUP);
  Serial.begin(9600);
  pressedFor = 0;
}

void loop() {
  if (digitalRead(18)) {
    if (isPressedDown == false) {
      Serial.println("up");
      digitalWrite(ONBOARD_LED, LOW);
      isPressedDown = true;
      Serial.print("button was pressed down for: ");
      Serial.print(pressedFor);
      Serial.println(" ticks.");
      pressedFor = 0;
    }
  } else {
    pressedFor ++;
    digitalWrite(ONBOARD_LED, HIGH);
    Serial.println("down");
    isPressedDown = false;
  }
}
