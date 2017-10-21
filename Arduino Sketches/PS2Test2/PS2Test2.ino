  //The last one was for Ps1. This one actually is for Ps2.
  //Pretty sure it'll work just fine.
  
  //Much of the following code was adapted from PS2X_Example.ino in the Arduino-PS2X git repo.
  #include <PS2X_lib.h>
  
  const int dataPin = 9;
  const int cmndPin = 12;
  const int attPin = 11;
  const int clockPin = 10;
  
  const int LEDPin = 13;
  
  const bool pressure = false;
  const bool rumble = false;
  
  int error = 0;
  byte type = 0;
  
  PS2X controller;
  
  void setup() {
    Serial.begin(57600);
    delay(300);
    error = controller.config_gamepad(clockPin, cmndPin, attPin, dataPin, pressure, rumble);
    
    //|||||||||||||||||||||||||||||||||||||||||||||HANDLE ERROR CASES|||||||||||||||||||||||||||||||||||||||||||||
    if(error == 0){
      Serial.print("Found Controller, configured successful ");
      Serial.print("pressures = ");
    if (pressure)
      Serial.println("true ");
    else
      Serial.println("false");
    Serial.print("rumble = ");
    if (rumble)
      Serial.println("true)");
    else
      Serial.println("false");
      Serial.println("Try out all the buttons, X will vibrate the controller, faster as you press harder;");
      Serial.println("holding L1 or R1 will print out the analog stick values.");
      Serial.println("Note: Go to www.billporter.info for updates and to report bugs.");
    }  
    else if(error == 1)
      Serial.println("No controller found, check wiring, see readme.txt to enable debug. visit www.billporter.info for troubleshooting tips");
     
    else if(error == 2)
      Serial.println("Controller found but not accepting commands. see readme.txt to enable debug. Visit www.billporter.info for troubleshooting tips");
  
    else if(error == 3)
      Serial.println("Controller refusing to enter Pressures mode, may not support it. ");
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
   type = controller.readType(); 
    switch(type) {
      case 0:
        Serial.println("Unknown Controller type found ");
        break;
      case 1:
        Serial.println("DualShock Controller found ");
        break;
      case 2:
        Serial.println("GuitarHero Controller found ");
        break;
    case 3:
        Serial.println("Wireless Sony DualShock Controller found ");
        break;
     }
    
  
  }
  
  void loop() {
    if(controller.Button(PSB_START))         //will be TRUE as long as button is pressed
      Serial.println("Start is being held");
    if(controller.Button(PSB_SELECT))
      Serial.println("Select is being held");      

    if(controller.Button(PSB_PAD_UP)) {      //will be TRUE as long as button is pressed
      Serial.print("Up held this hard: ");
      Serial.println(controller.Analog(PSAB_PAD_UP), DEC);
    }
    if(controller.Button(PSB_PAD_RIGHT)){
      Serial.print("Right held this hard: ");
      Serial.println(controller.Analog(PSAB_PAD_RIGHT), DEC);
    }
    if(controller.Button(PSB_PAD_LEFT)){
      Serial.print("LEFT held this hard: ");
      Serial.println(controller.Analog(PSAB_PAD_LEFT), DEC);
    }
    if(controller.Button(PSB_PAD_DOWN)){
      Serial.print("DOWN held this hard: ");
      Serial.println(controller.Analog(PSAB_PAD_DOWN), DEC);
    }
    
    delay(75);



    
  }















