  //Much of this code was taken directly from PS2X_Example.ino in the Arduino-PS2X git repo and
  //modified.
  #include <PS2X_lib.h>
  
  #define PS2_DAT        9   
  #define PS2_CMD        12
  #define PS2_SEL        11
  #define PS2_CLK        10
  #define LEDPin         13
  #define rumble      true
  #define pressures   true
  #define INFOSIZE    20
  #define BUTTONS     14
  #define CONTROLLERCHECKDELAY 35
  #define MESSAGEDELAY 10
  
  PS2X ps2x;
  
  int error = 0;
  byte info[INFOSIZE];
  
  void setup() {
    pinMode(LEDPin,OUTPUT);
    Serial.begin(9600);
    delay(500);
    error = ps2x.config_gamepad(PS2_CLK, PS2_CMD, PS2_SEL, PS2_DAT, pressures, rumble);
    
    //Handle errors
    if(error == 1){
      boolean on = false;
      while(true){
        digitalWrite(LEDPin, on?LOW:HIGH);
        on = !on;
        delay(100);
      }
    }
    if(error == 2){
      boolean on = false;
      while(true){
        digitalWrite(LEDPin, on?LOW:HIGH);
        on = !on;
        delay(200);
      }
    }
  
  //  Good to go. Initialize info[].
    for(int i = 0; i < INFOSIZE;i++){
      info[i]=0;
    }
    while(!Serial){
      delay(1000);
    }
    delay(300);
  }



  
  unsigned long lastCheck = 0;
  byte i = 0;
  byte j = 0;

  
  void loop() {
    for(i = 0; i<BUTTONS; i++){
      if (millis() - lastCheck > CONTROLLERCHECKDELAY){
        lastCheck = millis();
        ps2x.read_gamepad();
      }

      byte stickVal = ps2x.Analog(indexToControl(j+16));
      if(info[j+16]!=stickVal){
        info[j+16] = stickVal;
        Serial.write(j+16);
        Serial.write(stickVal);
        delay(MESSAGEDELAY);
      }
      j = (j+1)%4;
      
      //check the given button
      boolean buttonVal = ps2x.Button(indexToControl(i));
      //If the button has changed
      if((buttonVal?1:0) != info[i]){
        info[i] = buttonVal?1:0;
        Serial.write(i);
        Serial.write((byte)(buttonVal?1:0));
        delay(MESSAGEDELAY);
      }
    }
    
    
  //  info[0] = ps2x.Button(PSB_START)?1:0;
  //  info[1] = ps2x.Button(PSB_SELECT)?1:0;
  //  info[2] = ps2x.Button(PSB_TRIANGLE)?1:0;
  //  info[3] = ps2x.Button(PSB_CROSS)?1:0;
  //  info[4] = ps2x.Button(PSB_SQUARE)?1:0;
  //  info[5] = ps2x.Button(PSB_CIRCLE)?1:0;
  //  info[6] = ps2x.Button(PSB_PAD_UP)?1:0;
  //  info[7] = ps2x.Button(PSB_PAD_DOWN)?1:0;
  //  info[8] = ps2x.Button(PSB_PAD_RIGHT)?1:0;
  //  info[9] = ps2x.Button(PSB_PAD_LEFT)?1:0;
  //  info[10] = ps2x.Button(PSB_L1)?1:0;
  //  info[11] = ps2x.Button(PSB_R1)?1:0;
  //  info[12] = ps2x.Button(PSB_L2)?1:0;
  //  info[13] = ps2x.Button(PSB_R2)?1:0;
  //  info[14] = ps2x.Analog(PSS_LX);
  //  info[15] = ps2x.Analog(PSS_LY);
  //  info[16] = ps2x.Analog(PSS_RX);
  //  info[17] = ps2x.Analog(PSS_RY);
  //  info[18] = ps2x.Button(PSB_L3);
  //  info[19] = ps2x.Button(PSB_R3);
  //  
  //
  //  //if(Serial)
  //  for(int i = 0; i < INFOSIZE; i++){
  //    Serial.write(info[i]);
  //  }
  //  delay(50);
    
  }
  
  int indexToControl(int index){
    switch(index){
      case 0: return PSB_START;
      case 1: return PSB_SELECT;
      case 2: return PSB_TRIANGLE;
      case 3: return PSB_CROSS;
      case 4: return PSB_SQUARE;
      case 5: return PSB_CIRCLE;
      case 6: return PSB_PAD_UP;
      case 7: return PSB_PAD_DOWN;
      case 8: return PSB_PAD_RIGHT;
      case 9: return PSB_PAD_LEFT;
      case 10: return PSB_L1;
      case 11: return PSB_R1;
      case 12: return PSB_L2;
      case 13: return PSB_R2;
      case 14: return PSB_L3;
      case 15: return PSB_R3;
      case 16: return PSS_LX;
      case 17: return PSS_LY;
      case 18: return PSS_RX;
      case 19: return PSS_RY;
      default: return -1;
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

