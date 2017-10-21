//Actually PS1

#include <Psx.h>

const int dataPin = 9;
const int cmndPin = 12;
const int attPin = 11;
const int clockPin = 10;

const int LEDPin = 13;

Psx controller;
void setup() {
  pinMode(LEDPin, OUTPUT);
  controller.setupPins(dataPin,cmndPin,attPin,clockPin,10);
  Serial.begin(9600);
}
int data = 0;
void loop() {
  data = controller.read();
  digitalWrite(LEDPin, (data&psxO)? HIGH:LOW);
  delay(50);
}
