#include <dht.h>
#define DHTPIN 3
#define DHTTYPE DHT11
dht DHT;

int button = 2, sensore = 3, led = 4;
int temp = 0, umi = 0;
bool statoB = false;
String str = "";

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(button, INPUT);
  pinMode(led, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int chk = DHT.read11(DHTPIN);
  temp = DHT.temperature;
  statoB = digitalRead(button);
  
  Serial.print(temp);
  Serial.print(";");
  Serial.print(statoB);
  Serial.print(";");
  aspetta(60000);
}

void aspetta(int attesa){
  int i = 0;
  
  while(i < attesa){
    if (Serial.available())
      ledManager();
    else
      delay(1);
  }
}

void ledManager(){
    str = Serial.read();
    
    if (str.equals("lOn")){
      digitalWrite(led, HIGH);
      Serial.print("lIsOn");
    }
    else if (str.equals("lOf")){
      digitalWrite(led, LOW);
      Serial.print("lIsOf");
    }
}
