int buttonPin;
int buttonState;
// da definire i pin del sensore di temperatura
String str;

void setup() {
  // put your setup code here, to run once:
  buttonPin = 2;
  buttonState = 0;
  str = "";
  pinMode(buttonPin, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  buttonState = digitalRead(buttonPin);
  //lettura dati da sensore di temperatura
  //formattazione
  //scrittura su seriale
  delay(500);
}
