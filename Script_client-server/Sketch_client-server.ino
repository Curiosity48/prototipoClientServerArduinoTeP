#include <DHT.h>
#define DHTPIN 3
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

int button = 2;
int sensore = 3;
int temp = 0;
int umi = 0;
bool statoB = false;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(button, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  temp = dht.readTemperature();
  statoB = digitalRead(button);
  
  Serial.print("Temperatura: ");
  Serial.println(temp);
  Serial.print("Bottone: ");
  Serial.println(statoB);
  Serial.println();
  delay(250);
}
