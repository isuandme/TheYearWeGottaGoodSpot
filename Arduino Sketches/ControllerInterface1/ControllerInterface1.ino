//Much of this code was taken directly from PS2X_Example.ino in the Arduino-PS2X git repo and
//modified.
#include <PS2X_lib.h>

#define PS2_DAT        9   
#define PS2_CMD        12
#define PS2_SEL        11
#define PS2_CLK        10
#define LEDPin         13
#define rumble      false
#define pressures   false
#define INFOSIZE    20

PS2X ps2x;

int error = 0;
byte info[INFOSIZE];

void setup() {
  Serial.begin(9600);
  delay(300);
  error = ps2x.config_gamepad(PS2_CLK, PS2_CMD, PS2_SEL, PS2_DAT, pressures, rumble);

  //Handle errors
  if(error != 0 && error != 3){
    boolean on = false;
    while(true){
      digitalWrite(LEDPin, on?LOW:HIGH);
      delay(200);
    }
  }

  //Good to go. Initialize info[].
  for(int i = 0; i < INFOSIZE;i++){
    info[i]=0;
  }
}

void loop() {

  info[0] = ps2x.Button(PSB_START)?1:0;
  info[1] = ps2x.Button(PSB_SELECT)?1:0;
  info[2] = ps2x.Button(PSB_TRIANGLE)?1:0;
  info[3] = ps2x.Button(PSB_CROSS)?1:0;
  info[4] = ps2x.Button(PSB_SQUARE)?1:0;
  info[5] = ps2x.Button(PSB_CIRCLE)?1:0;
  info[6] = ps2x.Button(PSB_PAD_UP)?1:0;
  info[7] = ps2x.Button(PSB_PAD_DOWN)?1:0;
  info[8] = ps2x.Button(PSB_PAD_RIGHT)?1:0;
  info[9] = ps2x.Button(PSB_PAD_LEFT)?1:0;
  info[10] = ps2x.Button(PSB_L1)?1:0;
  info[11] = ps2x.Button(PSB_R1)?1:0;
  info[12] = ps2x.Button(PSB_L2)?1:0;
  info[13] = ps2x.Button(PSB_R2)?1:0;
  info[14] = ps2x.Analog(PSS_LX);
  info[15] = ps2x.Analog(PSS_LY);
  info[16] = ps2x.Analog(PSS_RX);
  info[17] = ps2x.Analog(PSS_RY);
  info[18] = ps2x.Button(PSB_L3);
  info[19] = ps2x.Button(PSB_R3);
  

  if(Serial){
    Serial.write(info,INFOSIZE);
  }
  delay(50);
  
}




















